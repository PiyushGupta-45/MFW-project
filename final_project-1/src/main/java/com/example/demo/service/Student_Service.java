package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Student;

public interface Student_Service {

    String createStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudent();
    String updateStudent(int id, Student student);    
    String deleteStudentById(int id);
}
