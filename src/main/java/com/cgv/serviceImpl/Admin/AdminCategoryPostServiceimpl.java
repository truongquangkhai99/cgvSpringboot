package com.cgv.serviceImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminCategoryPostDao;
import com.cgv.models.CategoryPost;
import com.cgv.service.Admin.AdminCategoryPostService;

@Service
public class AdminCategoryPostServiceimpl implements AdminCategoryPostService{
	@Autowired
	public AdminCategoryPostDao adminCategoryPostDao;
	@Override
	public List<CategoryPost> getAll(){
		return adminCategoryPostDao.getAll();
	}
	@Override
	public boolean insert(CategoryPost post) {
		return adminCategoryPostDao.insert(post);
	}
	@Override
	public boolean delete(int id) {
		return adminCategoryPostDao.delete(id);
	}
	@Override
	public boolean edit(CategoryPost post) {
		return adminCategoryPostDao.edit(post);
	}
}
