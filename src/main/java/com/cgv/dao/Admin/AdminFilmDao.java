package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.Film;

@Repository
public interface AdminFilmDao {

	public List<Film> getAll();
	
	public boolean insert(Film film);
	
	public boolean delete(int id);
	
	public boolean edit(Film id);
}
