package com.cgv.dao.Admin;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminHomeDao {
	public int countFilm();
	public int countUser();
	public int countBooking();
	public double totalMoney();
}
