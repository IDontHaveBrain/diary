package com.example.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.diary.dto.Diary;

@Mapper
public interface DiaryDao {
	public List<Diary> getDiaryList();	
}
