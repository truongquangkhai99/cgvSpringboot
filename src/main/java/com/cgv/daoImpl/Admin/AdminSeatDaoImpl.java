package com.cgv.daoImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminSeatDao;
import com.cgv.models.Seat;

@Repository
public class AdminSeatDaoImpl implements AdminSeatDao{
	public static final String GET_ALL="Select * from `seats`";
	public static final String ADD="INSERT INTO `seats` (`seat_name`) VALUES (?) ";
	public static final String DELETE="DELETE FROM `seats` WHERE id = ? ";
	public static final String UPDATE="UPDATE `seats` SET seat_name = ? WHERE id = ?";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<Seat> getAll(){
		List<Seat> list = new ArrayList<Seat>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(Seat.class));
		return list;
	}
	@Override
	public boolean insert(Seat seat) {
		int result=_jdbcTemplate.update(ADD, seat.getSeatName());
		if(result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(int id) {
		int result=_jdbcTemplate.update(DELETE, id);
		if(result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean edit(Seat seat) {
		int result=_jdbcTemplate.update(UPDATE, seat.getSeatName(),seat.getId());
		if(result == 1) {
			return true;
		}
		return false;
	}
}
