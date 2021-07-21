package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.CategoryFilm;

@Repository

public interface AdminCategoryFilmDao {
	public List<CategoryFilm> getAll();
	
	public boolean insert(CategoryFilm cfilm);
	
	public boolean delete(int id);
	
	public boolean edit(CategoryFilm cfilm);
}
