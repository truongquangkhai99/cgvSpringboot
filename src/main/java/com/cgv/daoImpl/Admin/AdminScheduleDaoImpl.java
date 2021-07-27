package com.cgv.daoImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminScheduleDao;
import com.cgv.models.Film;
import com.cgv.models.Schedule;
@Repository
public class AdminScheduleDaoImpl implements AdminScheduleDao{ 
	public static final String GET_ALL="Select * from `schedules` ORDER BY dateschedule  DESC";
	public static final String ADD="INSERT INTO `schedules` (`film_id`,`dateschedule`) VALUES (?,?) ";
	public static final String DELETE="DELETE FROM `schedules` WHERE id = ? ";
	public static final String UPDATE="UPDATE `schedules` SET film_id = ?,dateschedule = ? WHERE id = ?";
	public static final String GET_NAME = "SELECT * FROM `schedules` WHERE id = ?";
	
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<Schedule> getAll(){
		List<Schedule> list = new ArrayList<Schedule>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(Schedule.class));
		return list;
	}
	@Override
	public boolean insert(Schedule schedule) {
		int result=_jdbcTemplate.update(ADD, schedule.getFilmId(),schedule.getDateschedule());
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
	public boolean edit(Schedule schedule) {
		int result=_jdbcTemplate.update(UPDATE, schedule.getFilmId(),schedule.getDateschedule(),schedule.getId());
		if(result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public Schedule getName(int id) {
		// TODO Auto-generated method stub
		return _jdbcTemplate.queryForObject(GET_NAME, new BeanPropertyRowMapper<>(Schedule.class) , new Object[] {id});
	}
}
