package com.cgv.daoImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminRoomDao;
import com.cgv.models.Room;
import com.cgv.models.Schedule;

@Repository
public class AdminRoomDaoImpl implements AdminRoomDao{
	public static final String GET_ALL="Select * from `room`";
	public static final String ADD="INSERT INTO `room` (`room_name`) VALUES (?) ";
	public static final String DELETE="DELETE FROM `room` WHERE id = ? ";
	public static final String UPDATE="UPDATE `room` SET room_name = ? WHERE id = ?";
	public static final String GET_NAME = "SELECT * FROM `room` WHERE id = ?";
	
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<Room> getAll(){
		List<Room> list = new ArrayList<Room>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(Room.class));
		return list;
	}
	@Override
	public boolean insert(Room room) {
		int result=_jdbcTemplate.update(ADD, room.getRoomName());
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
	public boolean edit(Room room) {
		int result=_jdbcTemplate.update(UPDATE, room.getRoomName(),room.getId());
		if(result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public Room getName(int id) {
		// TODO Auto-generated method stub
		return _jdbcTemplate.queryForObject(GET_NAME, new BeanPropertyRowMapper<>(Room.class) , new Object[] {id});
	}
}
