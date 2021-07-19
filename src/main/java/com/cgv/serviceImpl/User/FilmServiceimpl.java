package com.cgv.serviceImpl.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgv.dao.User.FilmDao;
import com.cgv.models.Film;
import com.cgv.service.User.FilmService;

@Service
public class FilmServiceimpl implements FilmService{
	
	@Autowired
	public FilmDao filmDao;

	@Override
	public List<Film> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film getDetailFilm(int id) {
		// TODO Auto-generated method stub
		return filmDao.getDetailFilm(id);
	}

	@Override
	public List<Film> getFilmSapChieu() {
		// TODO Auto-generated method stub
		return filmDao.getFilmSapChieu();
	}

	@Override
	public List<Film> getFilmDangChieu() {
		// TODO Auto-generated method stub
		return filmDao.getFilmDangChieu();
	}

	@Override
	public List<Film> searchByName(String name) {
		// TODO Auto-generated method stub
		return filmDao.searchByName(name);
	}

}
