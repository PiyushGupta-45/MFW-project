package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Admin;

public interface Admin_Service {
    String createAdmin(Admin admin);
    Admin getAdminById(int id);
    List<Admin> getAllAdmin();
    String updateAdmin(int id, Admin admin);
    String deleteAdminById(int id);
}
