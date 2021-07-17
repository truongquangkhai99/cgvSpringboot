package com.cgv.daoImpl.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.cgv.dao.User.UserDao;
import com.cgv.models.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	public static final String REGISTER = "INSERT INTO `user`( `email`, `is_active`, `password`, `phone`, `role_id`, `username`) VALUES (?,?,?,?,?,?)";
	public static final String CHECKEXIT = "SELECT count(*) FROM user where email = ? ";
	
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(User user) {
		boolean checkExit = checkAccountExit(user.getEmail());

    if(checkExit == true){
        return false;
    }else{
        String passwordMd5 = md5(user.getPassword());
        int result = _jdbcTemplate.update(REGISTER,user.getEmail(),0,passwordMd5,user.getPhoneNumber(),user.getRoleId(),user.getUsername());
        if(result == 1){
            return true;
        }
    }
    return false;
	}

	@Override
	public String md5(String password) {
		 String result = "";
	        MessageDigest digest;
	        try {
	            digest = MessageDigest.getInstance("MD5");
	            digest.update(password.getBytes());
	            BigInteger bigInteger = new BigInteger(1,digest.digest());
	            result = bigInteger.toString(16);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return result;
	}

	@Override
	public boolean checkAccountExit(String email) {
		 int result = _jdbcTemplate.queryForObject(CHECKEXIT, new Object[] {email},Integer.class);
	        if (result == 1){
	            return true;
	        }
	        return false;
	}

}
