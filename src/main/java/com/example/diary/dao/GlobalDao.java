package com.example.diary.dao;

import com.example.diary.dto.Asd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GlobalDao {
    public List<Asd> getAsdList();
}
