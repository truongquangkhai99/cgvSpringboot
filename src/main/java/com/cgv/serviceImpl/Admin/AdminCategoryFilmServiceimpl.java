package com.cgv.serviceImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminCategoryFilmDao;
import com.cgv.dao.User.CategoryFilmDao;
import com.cgv.models.CategoryFilm;
import com.cgv.service.Admin.AdminCategoryFilmService;
@Service

public class AdminCategoryFilmServiceimpl implements AdminCategoryFilmService {
	@Autowired
	public AdminCategoryFilmDao adminCategoryFilmDao;
	@Override
	public List<CategoryFilm> getAll(){
		return adminCategoryFilmDao.getAll();
	}
	@Override
	public boolean insert(CategoryFilm cfilm) {
		return adminCategoryFilmDao.insert(cfilm);
	}
	@Override
	public boolean delete(int id) {
		return adminCategoryFilmDao.delete(id);
	}
	@Override
	public boolean edit(CategoryFilm cfilm) {
		
		return adminCategoryFilmDao.edit(cfilm);
	}
}
