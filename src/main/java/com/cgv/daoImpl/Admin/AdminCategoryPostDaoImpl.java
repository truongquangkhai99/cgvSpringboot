package com.cgv.daoImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminCategoryPostDao;

import com.cgv.models.CategoryPost;
@Repository
public class AdminCategoryPostDaoImpl implements AdminCategoryPostDao{
	public static final String GET_ALL="Select * from `category_post`";
	public static final String ADD="INSERT INTO `category_post` (`name`) VALUES (?) ";
	public static final String DELETE="DELETE FROM `category_post` WHERE id = ? ";
	public static final String UPDATE="UPDATE `category_post` SET name = ? WHERE id = ?";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<CategoryPost> getAll(){
		List<CategoryPost> list = new ArrayList<CategoryPost>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(CategoryPost.class));
		return list;
	}
	@Override
	public boolean insert(CategoryPost post) {
		int result = _jdbcTemplate.update(ADD, post.getName());
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
	public boolean edit(CategoryPost post) {
		int result = _jdbcTemplate.update(UPDATE, post.getName(),post.getId());
		if(result == 1) {
			return true;
		}
		return false;
	}
}
