package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.Role;
import com.cgv.models.User;

@Repository
public interface AdminUserDao {
	public List<User> getAll();
	
	public boolean insert(User user);
	
	public boolean delete(int id);
	
	public boolean edit(User id);
	
	public List<Role> getRole();
	
	public boolean login(User user);
	
	public  String md5(String password);
	
	public boolean checkAccountExit(String email);
	
	 public User getInformation(String email);
	
	public void logout();
}
