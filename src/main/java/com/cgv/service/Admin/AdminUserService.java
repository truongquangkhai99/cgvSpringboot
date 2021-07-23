package com.cgv.service.Admin;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cgv.models.Role;
import com.cgv.models.User;

@Service
public interface AdminUserService {
	public List<User> getAll();
	
	public boolean insert(User user);
	
	public boolean delete(int id);
	
	public boolean edit(User id);
	
	public List<Role> getRole();
	
	public boolean login(User user);
	
	public  String md5(String password);
	
	public void logout();
	
	public boolean checkAccountExit(String email);
	
	 public User getInformation(String email);
}
