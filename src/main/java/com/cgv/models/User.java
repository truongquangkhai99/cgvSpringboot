package com.cgv.models;

public class User {
	
	private int id;
	private String email;
	private int isActive;
	private String password;
	private String phoneNumber;
	private int roleId;
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int isActive() {
		return isActive;
	}
	public void setActive(int isActive) {
		this.isActive = isActive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User(int id, String email, int isActive, String password, String phoneNumber, int roleId,
			String username) {
		super();
		this.id = id;
		this.email = email;
		this.isActive = isActive;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.roleId = roleId;
		this.username = username;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", isActive=" + isActive + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", roleId=" + roleId + ", username=" + username + "]";
	}
	

}
