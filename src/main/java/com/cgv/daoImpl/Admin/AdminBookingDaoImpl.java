package com.cgv.daoImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminBookingDao;
import com.cgv.models.Booking;

@Repository
public class AdminBookingDaoImpl implements AdminBookingDao{
	public static final String GET_ALL="Select * from `booking` ORDER BY id DESC";
	public static final String UPDATE="UPDATE `booking` SET status = ? WHERE id = ?";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<Booking> getAll(){
		List<Booking> list = new ArrayList<Booking>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(Booking.class));
		return list;
	}
	@Override
	public boolean edit(Booking id) {
		int result = _jdbcTemplate.update(UPDATE, id.getStatus(),id.getId());
		if(result == 1) {
			return true;
		}
		return false;
	}
}
