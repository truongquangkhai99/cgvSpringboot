package com.cgv.daoImpl.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminHomeDao;

@Repository
public class AdminHomeDaoImpl implements AdminHomeDao{
	public static final String COUNT_FILM = "SELECT COUNT(`id`) FROM `films`";
	public static final String COUNT_USER = "SELECT COUNT(`id`) FROM `user`";
	public static final String COUNT_BOOKING = "SELECT COUNT(`id`) FROM `booking`";
	public static final String TOTAL_MONEY = "SELECT SUM(`amount`) FROM `booking`";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public int countFilm() {
		int count = _jdbcTemplate.queryForObject(COUNT_FILM, Integer.class);
		return count;
	}
	@Override
	public int countUser() {
		int count = _jdbcTemplate.queryForObject(COUNT_USER, Integer.class);
		return count;
	}
	@Override
	public int countBooking() {
		int count = _jdbcTemplate.queryForObject(COUNT_BOOKING, Integer.class);
		return count;
	}
	@Override
	public double totalMoney() {
		double count = _jdbcTemplate.queryForObject(TOTAL_MONEY, Integer.class);
		return count;
	}
}
