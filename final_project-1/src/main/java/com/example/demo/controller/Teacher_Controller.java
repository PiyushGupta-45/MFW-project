package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Teacher;
import com.example.demo.service.Teacher_Service;

@RestController
@RequestMapping("/teacher")
public class Teacher_Controller {
	@Autowired
	private Teacher_Service teacher_service;
	 
	@PostMapping("/createteacher")
	public String saveTeacherData(@RequestBody Teacher teacher) {
		return teacher_service.createTeacher(teacher);
	}

	@GetMapping("/allteachers")
	public List<Teacher> getAllTeacher() {
		return teacher_service.getAllTeacher();
	}

	@GetMapping("/teacher/{id}")
	public Teacher getTeacherById(@PathVariable int id) {
		return teacher_service.getTeacherById(id);
	}

	@PutMapping("/teacher/{id}")
	public String updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
		return teacher_service.updateTeacher(id, teacher);
	}

	@DeleteMapping("/teacher/{id}")
	public String deleteTeacher(@PathVariable int id) {
		return teacher_service.deleteTeacherById(id);
	}
}
