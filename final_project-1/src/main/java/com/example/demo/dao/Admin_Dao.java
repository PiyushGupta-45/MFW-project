package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Admin;

public interface Admin_Dao {
	
	void createAdmin(Admin admin);
	Admin getAdminById(int Aid);
	List<Admin> getAllAdmin();
	void updateAdmin(Admin admin);
	void deleteAdminById(int id);
	
}
