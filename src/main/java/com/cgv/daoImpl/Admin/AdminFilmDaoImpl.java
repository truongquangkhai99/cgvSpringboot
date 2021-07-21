package com.cgv.daoImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminFilmDao;
import com.cgv.models.Film;

@Repository
public class AdminFilmDaoImpl implements AdminFilmDao{
	public static final String GET_ALL="Select * From `films`";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<Film> getAll(){
		List<Film> list = new ArrayList<Film>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(Film.class));
		return list;
	}
	@Override
	public boolean insert(Film film) {
		return false;
	}
	@Override
	public boolean delete(int id) {
		return false;
	}
	@Override
	public boolean edit(Film id) {
		return false;
	}
}
