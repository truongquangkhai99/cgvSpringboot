package com.cgv.dao.User;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.Film;


public interface FilmDao {
	
	public List<Film> getAll();
	
	public Film getDetailFilm(int id);
	
	public List<Film> getFilmSapChieu();
	
	public List<Film> getFilmDangChieu();
	
	public List<Film> searchByName(String name);

}
