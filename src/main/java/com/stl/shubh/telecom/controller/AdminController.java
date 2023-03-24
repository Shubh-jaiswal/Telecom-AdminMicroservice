package com.stl.shubh.telecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.shubh.telecom.jwt.JwtUtil;
import com.stl.shubh.telecom.model.Admin;
import com.stl.shubh.telecom.repository.AdminRepository;
import com.stl.shubh.telecom.security.AdminLoginDetails;
import com.stl.shubh.telecom.security.AdminLoginDetailsService;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/admin/auth")
public class AdminController {
  

	
	@Autowired 
	AdminRepository adminRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtils;
	
	@Autowired
	AdminLoginDetailsService adminLoginDetailsService;
	
	@PostMapping("/add")
	public String user(@RequestBody Admin admin) {
		try {
			BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
			String encPass = encoder.encode(admin.getAdminPassword());
			admin.setAdminPassword(encPass);
			adminRepository.save(admin);
			return "Admin Added!";
			
		}catch (Exception e) {
			e.printStackTrace();
			return "Could not add admin!";
		}
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody Admin admin ) {
	    try {
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(admin.getAdminEmail(), admin.getAdminPassword()));
	        if (authentication.isAuthenticated()) {
	            AdminLoginDetails userLoginDetails = (AdminLoginDetails) adminLoginDetailsService.loadUserByUsername(admin.getAdminEmail());
	            String token = jwtUtils.generateJwtToken(userLoginDetails);
	            return token;
	        } else {
	            return "Authentication Failed!";
	        }
	    } catch (Exception e) {
	        return "Authentication Failed! Check username & password.";
	    }
	}
	

	

}
