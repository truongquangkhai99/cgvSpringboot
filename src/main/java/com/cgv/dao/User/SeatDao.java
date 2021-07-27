package com.cgv.dao.User;

import org.springframework.stereotype.Repository;

import com.cgv.models.Seat;

@Repository
public interface SeatDao {
	public Seat getNameSeat(int id);
}
