package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Teacher;

public interface Teacher_Dao {

	void createTeacher(Teacher teacher);
	Teacher getTeacherById(int id);
	List<Teacher> getAllTeacher();
	void updateTeacher(Teacher teacher);
	void deleteTeacherById(int id);
}
