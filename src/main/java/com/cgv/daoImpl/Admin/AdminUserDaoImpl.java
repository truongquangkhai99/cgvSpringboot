package com.cgv.daoImpl.Admin;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminUserDao;
import com.cgv.models.Role;
import com.cgv.models.User;

@Repository
public class AdminUserDaoImpl implements AdminUserDao{
	public static final String GET_ALL="Select * from `user` ORDER BY role_id  ASC";
	public static final String ADD="INSERT INTO `user`( `email`, `is_active`, `password`, `phone`, `role_id`, `username`) VALUES (?,?,?,?,?,?) ";
	public static final String DELETE="DELETE FROM `user` WHERE id = ? ";
	public static final String UPDATE="UPDATE `user` SET email = ?,password = ?,phone = ?, role_id= ?, username = ? WHERE id = ?";
	public static final String GET_ROLE="Select * from `role`";
	public static final String CHECKLOGIN = "SELECT count(*) FROM user where role_id != 3 and email = ? and password = ? ";
	public static final String CHECKEXIT = "SELECT count(*) FROM user where email = ? ";
	public static final String GETINFO = "SELECT * FROM user where email = ?";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<User> getAll(){
		List<User> list = new ArrayList<User>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(User.class));
		return list;
	}
	@Override
	public boolean insert(User user) {
		boolean checkExit = checkAccountExit(user.getEmail());

	    if(checkExit == true){
	        return false;
	    }else {
		String passwordMd5 = md5(user.getPassword());
        int result = _jdbcTemplate.update(ADD,user.getEmail(),0,passwordMd5,user.getPhoneNumber(),user.getRoleId(),user.getUsername());
        if(result == 1){
            return true;
        }
	    }
		return false;
	}
	@Override
	public boolean delete(int id) {
		 int result=_jdbcTemplate.update(DELETE, id);
		 if(result == 1) { 
			 return true; }
		return false;
	}
	@Override
	public boolean edit(User id) {
		boolean checkExit = checkAccountExit(id.getEmail());

	    if(checkExit == true){
	        return false;
	    }else {
		String passwordMd5 = md5(id.getPassword());
        int result = _jdbcTemplate.update(UPDATE,id.getEmail(),passwordMd5,id.getPhoneNumber(),id.getRoleId(),id.getUsername(),id.getId());
        if(result == 1){
            return true;
        }
	    }
		return false;
	}
	@Override
	public List<Role> getRole(){
		List<Role> listR = new ArrayList<Role>();
		listR = _jdbcTemplate.query(GET_ROLE, new BeanPropertyRowMapper<>(Role.class));
		return listR;
	}
	@Override
	public boolean login(User user) {
		String passwordMd5 = md5(user.getPassword());
		int result = _jdbcTemplate.queryForObject(CHECKLOGIN, new Object[] {user.getEmail(),passwordMd5},Integer.class);
        if (result == 1){
            return true;
        }
        return false;
	}
	@Override
	public User getInformation(String email) {
		// TODO Auto-generated method stub
		return _jdbcTemplate.queryForObject(GETINFO, new BeanPropertyRowMapper<>(User.class) , new Object[] {email});
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
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean checkAccountExit(String email) {
		@SuppressWarnings("deprecation")
		int result = _jdbcTemplate.queryForObject(CHECKEXIT, new Object[] {email},Integer.class);
	        if (result == 1){
	            return true;
	        }
	        return false;
	}
}
