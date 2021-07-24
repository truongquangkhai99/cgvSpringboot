package com.cgv.serviceImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminPostDao;
import com.cgv.models.Post;
import com.cgv.service.Admin.AdminPostService;

@Service
public class AdminPostServiceimpl implements AdminPostService{
	@Autowired
	public AdminPostDao adminPostDao;
	@Override
	public List<Post> getAll(){
		return adminPostDao.getAll();
	}
	@Override
	public boolean insert(Post post) {
		return adminPostDao.insert(post);
	}
	@Override
	public boolean delete(int id) {
		return adminPostDao.delete(id);
	}
	@Override
	public boolean edit(Post id) {
		return adminPostDao.edit(id);
	}
}
