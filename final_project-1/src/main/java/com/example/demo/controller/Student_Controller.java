package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.Student_Service;

@RestController
@RequestMapping("/Student")
public class Student_Controller {
	@Autowired
	private Student_Service student_service;
	 
	@PostMapping("/create")
	public String saveStudentData(@RequestBody Student student) {
		return student_service.createStudent(student);
	}

	@GetMapping("/all")
	public List<Student> getAllStudent() {
		return student_service.getAllStudent();
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		return student_service.getStudentById(id);
	}

	@PutMapping("/{id}")
	public String updateStudent(@PathVariable int id, @RequestBody Student student) {
		return student_service.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		return student_service.deleteStudentById(id);
	}
}
