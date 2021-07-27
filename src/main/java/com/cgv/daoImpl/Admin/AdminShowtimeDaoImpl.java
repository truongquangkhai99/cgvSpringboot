package com.cgv.daoImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminShowtimeDao;
import com.cgv.models.Schedule;
import com.cgv.models.Showtime;

@Repository
public class AdminShowtimeDaoImpl implements AdminShowtimeDao{
	public static final String GET_ALL="Select * from `showtimes` ORDER BY id DESC";
	public static final String ADD="INSERT INTO `showtimes` (`schedule_id`,`start_time`,`end_time`) VALUES (?,?,?) ";
	public static final String DELETE="DELETE FROM `showtimes` WHERE id = ? ";
	public static final String UPDATE="UPDATE `showtimes` SET start_time = ?,end_time = ? WHERE id = ?";
	public static final String GET_NAME = "SELECT * FROM `showtimes` WHERE id = ?";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<Showtime> getAll(){
		List<Showtime> list = new ArrayList<Showtime>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(Showtime.class));
		return list;
	}
	@Override
	public boolean insert(Showtime showtime) {
		int result=_jdbcTemplate.update(ADD, showtime.getScheduleId(),showtime.getStartTime(),showtime.getEndTime());
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
	public boolean edit(Showtime showtime) {
		int result = _jdbcTemplate.update(UPDATE, showtime.getStartTime(),showtime.getEndTime(),showtime.getId());
		if(result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public Showtime getName(int id) {
		// TODO Auto-generated method stub
		return _jdbcTemplate.queryForObject(GET_NAME, new BeanPropertyRowMapper<>(Showtime.class) , new Object[] {id});
	}
}
