package com.cgv.daoImpl.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.User.SeatDao;
import com.cgv.models.Post;
import com.cgv.models.Seat;

@Repository
public class SeatDaoImpl implements SeatDao{
	public static final String GET_NAME = "SELECT * FROM `seats` WHERE id = ?";
	
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	@Override
	public Seat getNameSeat(int id) {
		// TODO Auto-generated method stub
		return _jdbcTemplate.queryForObject(GET_NAME, new BeanPropertyRowMapper<>(Seat.class), new Object[] {id});
	}
	

}
