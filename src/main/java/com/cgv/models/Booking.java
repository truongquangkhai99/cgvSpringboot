package com.cgv.models;

public class Booking {
	private int id;
	private int userId;
	private int filmId;
	private int scheduleId;
	private int showtimeId;
	private int roomId;
	private int seatId;
	private int amount;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public int getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Booking(int id, int userId, int filmId, int scheduleId, int showtimeId, int roomId, int seatId, int amount,
			int status) {
		super();
		this.id = id;
		this.userId = userId;
		this.filmId = filmId;
		this.scheduleId = scheduleId;
		this.showtimeId = showtimeId;
		this.roomId = roomId;
		this.seatId = seatId;
		this.amount = amount;
		this.status = status;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", userId=" + userId + ", filmId=" + filmId + ", scheduleId=" + scheduleId
				+ ", showtimeId=" + showtimeId + ", roomId=" + roomId + ", seatId=" + seatId + ", amount=" + amount
				+ ", status=" + status + "]";
	}
	
	

}
