package com.cgv.serviceImpl.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgv.dao.User.UserDao;
import com.cgv.models.User;
import com.cgv.service.User.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDao userDao;

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return userDao.register(user);
	}

	@Override
	public String md5(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAccountExit(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getInformation(String email) {
		// TODO Auto-generated method stub
		return userDao.getInformation(email);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

}
