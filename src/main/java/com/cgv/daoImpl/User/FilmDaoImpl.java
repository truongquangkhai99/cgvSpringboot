package com.cgv.daoImpl.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.User.FilmDao;
import com.cgv.models.Film;

@Repository
public class FilmDaoImpl implements FilmDao{
	public static final String GET_FILM_DANG_CHIEU = "SELECT * FROM `films` WHERE id_cpost = 2 limit 4";
	public static final String GET_FILM_SAP_CHIEU = "SELECT * FROM `films` WHERE id_cpost = 1"	;
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	@Override
	public List<Film> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film getDetailFilm(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> getFilmSapChieu() {
		List<Film> list = new ArrayList<Film>();
		list = _jdbcTemplate.query(GET_FILM_SAP_CHIEU, new BeanPropertyRowMapper<>(Film.class));
		return list;
	}

	@Override
	public List<Film> getFilmDangChieu() {
		List<Film> list = new ArrayList<Film>();
		list = _jdbcTemplate.query(GET_FILM_DANG_CHIEU, new BeanPropertyRowMapper<>(Film.class));
		return list;
	}

}
