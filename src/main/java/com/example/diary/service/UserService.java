package com.example.diary.service;

import com.example.diary.dao.UserRepository;
import com.example.diary.dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String pw) {
        return userRepository.findByEmailAndPw(email, pw) != null;
    }

    public boolean kakaoLogin(String token, HttpSession session) {
        try {
            URL url = new URL("https://kapi.kakao.com/v2/user/me");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                String body = "";
                while ((line = br.readLine()) != null) {
                    body += line;
                }
                System.out.println(body);
                ObjectMapper mapper = new ObjectMapper();
                Map kakao = mapper.readValue(body, Map.class);
                System.out.println("1. "+kakao.get("kakao_account"));
                System.out.println("2. "+((Map)kakao.get("kakao_account")).get("email"));
                Map kakao_account = (Map) kakao.get("kakao_account");
                System.out.println("3. "+((Map)kakao_account.get("profile")).get("nickname"));


                if(!(boolean)kakao_account.get("has_email"))
                    return false;
                String email = (String) kakao_account.get("email");
                User user = userRepository.findByEmail(email);
                if (user != null) {
                    session.setAttribute("user", user);
                    return true;
                } else {
                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setPw(UUID.randomUUID().toString().substring(0, 6));
                    newUser.setNick((String)((Map)kakao_account.get("profile")).get("nickname"));
                    userRepository.save(newUser);
                    session.setAttribute("user", newUser);
                    return true;
                }
            } else
                return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User getUser(String email, String pw) {
        return userRepository.findByEmailAndPw(email, pw);
    }

    public void signup(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }
}
