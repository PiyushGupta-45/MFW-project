package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.Admin_Dao;
import com.example.demo.entity.Admin;

@Service
public class Admin_Service_Impl implements Admin_Service {

    @Autowired
    Admin_Dao admin_dao;

    @Override
    public String createAdmin(Admin admin) {
        admin_dao.createAdmin(admin);
        return "Admin created successfully!";
    }

    @Override
    public Admin getAdminById(int id) {
        return admin_dao.getAdminById(id);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return admin_dao.getAllAdmin();
    }

    @Override
    public String updateAdmin(int id, Admin admin) {
        Admin existingAdmin = admin_dao.getAdminById(id);
        if (existingAdmin == null) {
            return "Admin with ID " + id + " not found!";
        }

        existingAdmin.setName(admin.getName());
        existingAdmin.setEmail(admin.getEmail());
        existingAdmin.setPhoneNumber(admin.getPhoneNumber());
        existingAdmin.setGender(admin.getGender());
        existingAdmin.setAddress(admin.getAddress());
        existingAdmin.setAssigned_Departments(admin.getAssigned_Departments());

        admin_dao.createAdmin(existingAdmin);
        return "Admin updated successfully!";
    }

    @Override
    public String deleteAdminById(int id) {
        Admin existingAdmin = admin_dao.getAdminById(id);
        if (existingAdmin == null) {
            return "Admin with ID " + id + " not found!";
        }

        admin_dao.deleteAdminById(id);
        return "Admin deleted successfully!";
    }
}
