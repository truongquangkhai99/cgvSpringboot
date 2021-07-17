package com.cgv.models;

public class Room {
	private int id;
	private String roomName;
	private int status;
	private int showtimeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int isStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}
	public Room(int id, String roomName, int status, int showtimeId) {
		super();
		this.id = id;
		this.roomName = roomName;
		this.status = status;
		this.showtimeId = showtimeId;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomName=" + roomName + ", status=" + status + ", showtimeId=" + showtimeId + "]";
	}
	

}
