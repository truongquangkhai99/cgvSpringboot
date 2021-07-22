package com.cgv.daoImpl.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.User.CommentDao;
import com.cgv.models.Film;
import com.cgv.models.Rating;

@Repository
public class CommentDaoImpl implements CommentDao{
	public static final String GET_COMMENT_BY_ID = "SELECT * FROM `ratings` WHERE film_id = ?";
	public static final String COMMENT = "INSERT INTO `ratings`( `film_id`, `rate`, `user_id`,`name_user`) VALUES (?,?,?,?)";
	
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	@Override
	public List<Rating> getCommentById(int id) {
		// TODO Auto-generated method stub
		return _jdbcTemplate.query(GET_COMMENT_BY_ID, new BeanPropertyRowMapper<>(Rating.class), new Object[] {id} );
	}

	@Override
	public boolean comment(Rating rating) {
		// TODO Auto-generated method stub
		int result = _jdbcTemplate.update(COMMENT,rating.getFilmId(),rating.getRate(),rating.getUserId(),rating.getName_user());
		if(result == 1) {
			return true;
		}
		return false;
	}

}
