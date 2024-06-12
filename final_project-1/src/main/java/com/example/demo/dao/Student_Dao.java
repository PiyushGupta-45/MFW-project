package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Student;

public interface Student_Dao {

	void createStudent(Student student);
	Student getStudentById(int id);
	List<Student> getAllStudent();
	void updateStudent(Student student);	
	void deleteStudentById(int id);
}
