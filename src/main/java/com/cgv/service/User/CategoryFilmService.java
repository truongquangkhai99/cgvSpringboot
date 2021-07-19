package com.cgv.service.User;

import org.springframework.stereotype.Service;

import com.cgv.models.CategoryFilm;
@Service
public interface CategoryFilmService {
	public CategoryFilm getCFilm(int id);
}
