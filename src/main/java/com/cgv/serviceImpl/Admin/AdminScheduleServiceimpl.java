package com.cgv.serviceImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.cgv.dao.Admin.AdminScheduleDao;
import com.cgv.models.Schedule;
import com.cgv.service.Admin.AdminScheduleService;
@Service
public class AdminScheduleServiceimpl implements AdminScheduleService{
	@Autowired
	public AdminScheduleDao adminScheduleDao;
	@Override
	public List<Schedule> getAll(){
		return adminScheduleDao.getAll();
	}
	@Override
	public boolean insert(Schedule schedule) {
		return adminScheduleDao.insert(schedule);
	}
	@Override
	public boolean delete(int id) {
		return adminScheduleDao.delete(id);
	}
	@Override
	public boolean edit(Schedule schedule) {
		return adminScheduleDao.edit(schedule);
	}
	@Override
	public Schedule getName(int id) {
		// TODO Auto-generated method stub
		return adminScheduleDao.getName(id);
	}
}
