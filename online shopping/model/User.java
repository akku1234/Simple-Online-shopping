package com.llts.miniproject.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String email;
	private String uname;
	private String mobile;
	private String address;
	private LocalDate dob;
	private String password;
	private String role;
	
	public User() {
		super();
	}
	public User(String email, String uname, String  mobile, String address, LocalDate dob, String password, String role) {
		super();
		this.email = email;
		this.uname = uname;
		this.mobile = mobile;
		this.address = address;
		this.dob = dob;
		this.role = role;
		this.password =password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return uname;
	}
	public void setName(String uname) {
		this.uname = uname;
	}
	public String  getMobile() {
		return mobile;
	}
	public void setMobile(String  mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User email=" + email + ", uname=" + uname + ", mobile=" + mobile + ", address=" + address + ", dob="
				+ dob + ", password=" + password +", role=" + role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
