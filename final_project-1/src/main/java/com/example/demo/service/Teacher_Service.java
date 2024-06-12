package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Teacher;

public interface Teacher_Service {

	String createTeacher(Teacher teacher);
	Teacher getTeacherById(int id);
	List<Teacher> getAllTeacher();
	String updateTeacher(int Tid, Teacher teacher);
	String deleteTeacherById(int id);
}
