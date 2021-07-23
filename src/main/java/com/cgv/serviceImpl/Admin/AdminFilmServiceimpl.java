package com.cgv.serviceImpl.Admin;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminFilmDao;
import com.cgv.models.Film;
import com.cgv.service.Admin.AdminFilmService;

@Service
public class AdminFilmServiceimpl implements AdminFilmService{
	@Autowired
	public AdminFilmDao adminFilmDao;
	@Override
	public List<Film> getAll(){
		return adminFilmDao.getAll();
	}
	@Override
	public boolean insert(Film film) {
		return adminFilmDao.insert(film);
	}
	@Override
	public boolean delete(int id) {
		return adminFilmDao.delete(id);
	}
	@Override
	public boolean edit(Film id) {
		return adminFilmDao.edit(id);
	}
}
