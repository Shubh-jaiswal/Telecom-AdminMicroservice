package com.stl.shubh.telecom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stl.shubh.telecom.model.Admin;
import com.stl.shubh.telecom.repository.AdminRepository;


@Service
public class AdminLoginDetailsService implements UserDetailsService {
	
	 @Autowired
	    AdminRepository adminRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Admin admin = adminRepository.findById(username).get();
	        return new AdminLoginDetails(admin);
	    }

	

}
