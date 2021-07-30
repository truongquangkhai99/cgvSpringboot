package com.cgv.daoImpl.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.User.PostDao;
import com.cgv.models.Post;
@Repository
public class PostDaoImpl implements PostDao{
	public static final String GET_PROMOTION = "SELECT * FROM `post` WHERE id_cpost = 1 ORDER BY id DESC";
	public static final String GET_INFOR = "SELECT * FROM `post` WHERE id_cpost = 2";
	public static final String GET_DETAIL = "SELECT * FROM `post` WHERE id = ?";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<Post> getPromotion(){
		return _jdbcTemplate.query(GET_PROMOTION, new BeanPropertyRowMapper<>(Post.class));
	}
	@Override
	public List<Post> getInfor(){
		return _jdbcTemplate.query(GET_INFOR, new BeanPropertyRowMapper<>(Post.class));
	}
	@Override
	public Post getDetail(int id) {
		return _jdbcTemplate.queryForObject(GET_DETAIL, new BeanPropertyRowMapper<>(Post.class), new Object[] {id});
	}
}
