package com.stl.shubh.telecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.shubh.telecom.model.Admin;
import com.stl.shubh.telecom.repository.AdminRepository;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/admin")
public class AdminDetailsController {

	@Autowired
    AdminRepository adminRepository;
	
	@GetMapping("/all")
	public List<Admin> getAllUsers(){
	    List<Admin> admin = adminRepository.findAll();
	    return admin;
	}

	//Fetching Customers By ID
	@GetMapping("/{email}")
	public Optional<Admin> getUserByEmail(@PathVariable("email") String email) {
	    return adminRepository.findById(email);
	}

}
