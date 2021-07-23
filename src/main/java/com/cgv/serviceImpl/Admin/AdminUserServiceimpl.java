package com.cgv.serviceImpl.Admin;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminUserDao;
import com.cgv.models.Role;
import com.cgv.models.User;
import com.cgv.service.Admin.AdminUserService;
@Service
public class AdminUserServiceimpl implements AdminUserService{
	@Autowired
	public AdminUserDao adminUserDao;
	@Override
	public List<User> getAll(){
		return adminUserDao.getAll();
	}
	@Override
	public boolean insert(User user) {
		return adminUserDao.insert(user);
	}
	@Override
	public boolean delete(int id) {
		return adminUserDao.delete(id);
	}
	@Override
	public boolean edit(User id) {
		return adminUserDao.edit(id);
	}
	@Override
	public List<Role> getRole(){
		return adminUserDao.getRole();
	}
	@Override
	public boolean login(User user) {
		return adminUserDao.login(user);
	}
	@Override
	public String md5(String password) {
		return null;
	}
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User getInformation(String email) {
		// TODO Auto-generated method stub
		return adminUserDao.getInformation(email);
	}
	@Override
	public boolean checkAccountExit(String username) {
		// TODO Auto-generated method stub
		return false;
	}
}
