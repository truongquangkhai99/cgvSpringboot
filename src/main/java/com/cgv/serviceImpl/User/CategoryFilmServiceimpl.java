package com.cgv.serviceImpl.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgv.dao.User.CategoryFilmDao;
import com.cgv.models.CategoryFilm;
import com.cgv.service.User.CategoryFilmService;

@Service
public class CategoryFilmServiceimpl implements CategoryFilmService{
	@Autowired
	public CategoryFilmDao  categoryFilmDao;
	@Override
	public CategoryFilm getCFilm(int id) {
		return categoryFilmDao.getCFilm(id);
	}
}
