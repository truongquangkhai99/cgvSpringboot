package com.cgv.service.User;

import org.springframework.stereotype.Service;

import com.cgv.models.User;

@Service
public interface UserService {
	public boolean login(User user);
	
	public boolean register(User user);
	
	 public  String md5(String password);

	   public boolean checkAccountExit(String email);
}
