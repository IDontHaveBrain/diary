package com.example.diary.service;

import com.example.diary.dao.UserRepository;
import com.example.diary.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String pw) {
        return userRepository.findByEmailAndPw(email, pw) != null;
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
