package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Teacher_Dao;
import com.example.demo.entity.Teacher;

@Service
public class Teacher_Service_Impl implements Teacher_Service {
	@Autowired
	Teacher_Dao teacher_dao;

	@Override
	public String createTeacher(Teacher teacher) {
		teacher_dao.createTeacher(teacher);
		return "Teacher created successfully!";
	}

	@Override
	public Teacher getTeacherById(int id) {
		return teacher_dao.getTeacherById(id);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return teacher_dao.getAllTeacher();
	}

	@Override
	public String updateTeacher(int Tid, Teacher teacher) {
		Teacher existingTeacher = teacher_dao.getTeacherById(Tid);
		if (existingTeacher == null) {
            return "Teacher with ID " + Tid + " not found!";
        }
				
		existingTeacher.setTname(teacher.getTname());
		existingTeacher.setPhoneNo(teacher.getPhoneNo());
		existingTeacher.setGender(teacher.getGender());
		existingTeacher.setSalary(teacher.getSalary());

		teacher_dao.updateTeacher(existingTeacher);
        return "Teacher updated successfully!";
	}

	@Override
	public String deleteTeacherById(int id) {
		Teacher existingTeacher = teacher_dao.getTeacherById(id);
        if (existingTeacher == null) {
            return "Teacher with ID " + id + " not found!";
        }

        teacher_dao.deleteTeacherById(id);
        return "Teacher deleted successfully!";
	}
}
