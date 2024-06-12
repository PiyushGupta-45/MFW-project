package com.example.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class Admin_Dao_Impl implements Admin_Dao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createAdmin(Admin admin) {
		entityManager.persist(admin);
	}

	@Override
	public Admin getAdminById(int Aid) {
		return entityManager.find(Admin.class, Aid);
	}

	@Override
	public List<Admin> getAllAdmin() {
		String jpql = "SELECT a FROM Admin a";
		Query query = entityManager.createQuery(jpql, Admin.class);
		return query.getResultList();
	}

	@Override
	public void updateAdmin(Admin admin) {
		entityManager.merge(admin);
	}

	@Override
	public void deleteAdminById(int id) {
		Admin admin = entityManager.find(Admin.class, id);
		if (admin != null) {
			entityManager.remove(admin);
		}
	}
}
