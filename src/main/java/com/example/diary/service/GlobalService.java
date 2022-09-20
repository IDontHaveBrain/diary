package com.example.diary.service;

import com.example.diary.dao.GlobalDao;
import com.example.diary.dao.UserRepository;
import com.example.diary.dto.Asd;
import com.example.diary.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, String> getErrors(Errors errors) {
        Map<String, String> result = new HashMap<>();
        for(FieldError error : errors.getFieldErrors()) {
            result.put(error.getField(), error.getDefaultMessage());
        }
        return result;
    }
}
