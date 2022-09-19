package com.example.diary.service;

import com.example.diary.dao.GlobalDao;
import com.example.diary.dao.UserRepository;
import com.example.diary.dto.Asd;
import com.example.diary.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalService {
    @Autowired
    private GlobalDao globalDao;

    @Autowired
    private UserRepository userRepository;

    public List<Asd> getAsdList() {
        return globalDao.getAsdList();
    }
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
