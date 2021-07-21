package com.cgv.service.Admin;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cgv.models.Film;

@Service
public interface AdminFilmService {

	public List<Film> getAll();
	
	public boolean insert(Film film);
	
	public boolean delete(int id);
	
	public boolean edit(Film id);
}
