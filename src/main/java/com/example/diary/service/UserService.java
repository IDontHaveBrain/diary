package com.example.diary.service;

import com.example.diary.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String pw) {
        return userRepository.findByEmailAndPw(email, pw) != null;
    }
}
