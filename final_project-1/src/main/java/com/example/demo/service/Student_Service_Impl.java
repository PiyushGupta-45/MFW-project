	package com.example.demo.service;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.example.demo.dao.Student_Dao;
	import com.example.demo.entity.Student;
	
	@Service
	public class Student_Service_Impl implements Student_Service {
		@Autowired
		Student_Dao student_dao;
	
		@Override
		public String createStudent(Student student) {
			student_dao.createStudent(student);
			return "student created successfully!";
		}
	
		@Override
		public Student getStudentById(int id) {
			return student_dao.getStudentById(id);
		}
	
		@Override
		public List<Student> getAllStudent() {
			return student_dao.getAllStudent();
		}
	
		@Override
		public String updateStudent(int id, Student student) {
			Student existingStudent = student_dao.getStudentById(id);
			if (existingStudent == null) {
	            return "Student with ID " + id + " not found!";
	        }
					
			existingStudent.setName(student.getName());
			existingStudent.setRollNo(student.getRollNo());
			existingStudent.setSection(student.getSection());
			existingStudent.setGender(student.getGender());
			existingStudent.setStream(student.getStream());
			existingStudent.setDob(student.getDob());
	
			student_dao.updateStudent(existingStudent);
	        return "Student updated successfully!";
		}
	
		@Override
		public String deleteStudentById(int id) {
			Student existingStudent = student_dao.getStudentById(id);
	        if (existingStudent == null) {
	            return "Student with ID " + id + " not found!";
	        }
	
	        student_dao.deleteStudentById(id);
	        return "Student deleted successfully!";
		}
	}
