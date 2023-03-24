package com.stl.shubh.telecom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="telecom_admin")
public class Admin {

	@Id
	@Column(name="admin_email")
	private String adminEmail;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="admin_password")
	private String adminPassword;
	
	@Column(name="admin_phone_number")
	private String adminPhoneNumber;

	public Admin() {
		super();
	}

	public Admin(String adminEmail, String adminName, String adminPassword, String adminPhoneNumber) {
		super();
		this.adminEmail = adminEmail;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminPhoneNumber = adminPhoneNumber;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminPhoneNumber() {
		return adminPhoneNumber;
	}

	public void setAdminPhoneNumber(String adminPhoneNumber) {
		this.adminPhoneNumber = adminPhoneNumber;
	}

	@Override
	public String toString() {
		return "Admin [adminEmail=" + adminEmail + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", adminPhoneNumber=" + adminPhoneNumber + "]";
	}
	

}
