	package com.example.demo.dao;
	
	import java.util.List;
	import org.springframework.stereotype.Repository;
	import com.example.demo.entity.Student;
	import jakarta.persistence.EntityManager;
	import jakarta.persistence.PersistenceContext;
	import jakarta.persistence.Query;
	import jakarta.transaction.Transactional;
	
	@Repository
	@Transactional
	public class Student_Dao_Impl implements Student_Dao{
	
		@PersistenceContext
		private EntityManager entityManager;
		
		@Override
		public void createStudent(Student student) {
			entityManager.persist(student);
			
		}
	
		@Override
		public Student getStudentById(int id) {
			 return entityManager.find(Student.class, id);
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public List<Student> getAllStudent() {
			 String jpql = "SELECT s FROM Student s";
		     Query query = entityManager.createQuery(jpql, Student.class);
		     return query.getResultList();
		}
	
		@Override
		public void updateStudent(Student student) {
			entityManager.merge(student);
		}
	
		@Override
		public void deleteStudentById(int id) {
			Student student = entityManager.find(Student.class, id);
	        if (student != null) {
	            entityManager.remove(student);
	        }
			
		}
	
		
	}
