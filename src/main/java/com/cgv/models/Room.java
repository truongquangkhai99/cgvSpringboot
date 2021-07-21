package com.cgv.models;

public class Room {
	private int id;
	private String roomName;
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
	public Room(int id, String roomName) {
		super();
		this.id = id;
		this.roomName = roomName;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomName=" + roomName + "]";
	}

	

}
