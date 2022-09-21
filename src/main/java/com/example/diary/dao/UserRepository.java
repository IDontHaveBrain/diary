package com.example.diary.dao;

import com.example.diary.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    User findByEmail(String email);
    User findByEmailAndPw(String email, String pw);
    boolean existsByEmail(String email);
}