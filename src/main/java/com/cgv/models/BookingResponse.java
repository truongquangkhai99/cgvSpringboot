package com.cgv.models;

public class BookingResponse {
	private String filmName;
	private String scheduleName;
	private String showtimeName;
	private String roomName;
	private int amount;
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public String getShowtimeName() {
		return showtimeName;
	}
	public void setShowtimeName(String showtimeName) {
		this.showtimeName = showtimeName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BookingResponse [filmName=" + filmName + ", scheduleName=" + scheduleName + ", showtimeName="
				+ showtimeName + ", roomName=" + roomName + ", amount=" + amount + "]";
	}
	public BookingResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
