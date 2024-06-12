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

import com.example.demo.entity.Admin;
import com.example.demo.service.Admin_Service;

@RestController
@RequestMapping("/admin")
public class Admin_Controller {

    @Autowired
    private Admin_Service admin_service;

    @PostMapping("/create")
	public String saveAdminData(@RequestBody  Admin teacher) {
		return admin_service.createAdmin(teacher);
	}

    @GetMapping("/all")
	public List< Admin> getAllAdmin() {
		return admin_service.getAllAdmin();
	}

	@GetMapping("/{id}")
	public  Admin getAdminById(@PathVariable int id) {
		return admin_service.getAdminById(id);
	}

	@PutMapping("/{id}")
	public String updateAdmin(@PathVariable int id, @RequestBody  Admin  admin) {
		return admin_service.updateAdmin(id, admin);
	}

	@DeleteMapping("/{id}")
	public String deleteAdmin(@PathVariable int id) {
		return admin_service.deleteAdminById(id);
	}
}
