package com.example.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class Teacher_Dao_Impl implements Teacher_Dao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createTeacher(Teacher teacher) {
		entityManager.persist(teacher);
	}

	@Override
	public Teacher getTeacherById(int id) {
		return entityManager.find(Teacher.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAllTeacher() {
		String jpql = "SELECT t FROM Teacher t";
	    Query query = entityManager.createQuery(jpql, Teacher.class);
	    return query.getResultList();
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		entityManager.merge(teacher);
	}

	@Override
	public void deleteTeacherById(int id) {
		Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher != null) {
        	entityManager.remove(teacher);
        }
	}
}
