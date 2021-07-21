package com.cgv.service.Admin;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cgv.models.CategoryFilm;

@Service

public interface AdminCategoryFilmService {
	public List<CategoryFilm> getAll();
	
	public boolean insert(CategoryFilm cfilm);
	
	public boolean delete(int id);
	
	public boolean edit(CategoryFilm id);
}
