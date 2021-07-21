package com.cgv.daoImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminCategoryFilmDao;
import com.cgv.models.CategoryFilm;

@Repository
public class AdminCategoryFilmDaoImpl implements AdminCategoryFilmDao{
	public static final String GET_ALL="Select * from `category_film`";
	public static final String ADD="INSERT INTO `category_film` (`name`) VALUES (?) ";
	public static final String DELETE="DELETE FROM `category_film` WHERE id = ? ";
	public static final String UPDATE="UPDATE `category_film` SET name = ? WHERE id = ?";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<CategoryFilm> getAll(){
		List<CategoryFilm> list = new ArrayList<CategoryFilm>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(CategoryFilm.class));
		return list;
	}
	@Override
	public boolean insert(CategoryFilm cfilm) {
		int result = _jdbcTemplate.update(ADD, cfilm.getName());
		if(result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(int id) {
		int result = _jdbcTemplate.update(DELETE, id);
		if(result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean edit(CategoryFilm cfilm) {
		int result = _jdbcTemplate.update(UPDATE, cfilm.getName(),cfilm.getId());
		if(result == 1) {
			return true;
		}
		return false;
	}
}
