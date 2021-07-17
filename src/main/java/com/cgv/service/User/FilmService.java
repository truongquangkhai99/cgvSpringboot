package com.cgv.service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgv.models.Film;

@Service
public interface FilmService {
	
	public List<Film> getAll();
	
	public Film getDetailFilm(int id);
	
	public List<Film> getFilmSapChieu();
	
	public List<Film> getFilmDangChieu();
	
	public List<Film> searchByName(String name);
}
