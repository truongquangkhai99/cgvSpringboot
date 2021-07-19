package com.cgv.daoImpl.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.User.CategoryFilmDao;
import com.cgv.models.CategoryFilm;
import com.cgv.models.Film;

@Repository
public class CategoryFilmDaoImpl implements CategoryFilmDao{
	public static final String GET_CATEGORY_FILM = "SELECT * FROM `category_film`  WHERE id = ?";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public CategoryFilm getCFilm(int id) {
		return _jdbcTemplate.queryForObject(GET_CATEGORY_FILM, new BeanPropertyRowMapper<>(CategoryFilm.class) , new Object[] {id});
	}

}
