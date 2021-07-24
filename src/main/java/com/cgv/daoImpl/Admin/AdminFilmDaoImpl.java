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
	public static final String INSERT = "INSERT INTO `films`( `description`, `director`, `actor`, `duration`, `film_name`, `image`, `trailer`, `id_cfilm`) VALUES (?,?,?,?,?,?,?,?)";
	public static final String DELETE = "DELETE FROM `films` WHERE id = ?";
	public static final String UPDATE = "UPDATE `films` SET `description`=?,`director`=?,`actor`=?,`duration`=?,`film_name`=?,`image`=?,`trailer`=?,`id_cfilm`= ? WHERE id = ?";
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
		int result = _jdbcTemplate.update(INSERT,film.getDescription(),film.getDirector(),film.getActor(),film.getDuration(),film.getFilmName(),film.getImage(),film.getTrailer(),film.getId_cfilm());
		if(result  == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(int id) {
		int result = _jdbcTemplate.update(DELETE,id);
		if(result  == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean edit(Film film) {
		int result = _jdbcTemplate.update(UPDATE,film.getDescription(),film.getDirector(),film.getActor(),film.getDuration(),film.getFilmName(),film.getImage(),film.getTrailer(),film.getId_cfilm(),film.getId());
		if(result  == 1) {
			return true;
		}
		return false;
	}
}
