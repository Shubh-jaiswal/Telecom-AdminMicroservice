package com.stl.shubh.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.shubh.telecom.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
