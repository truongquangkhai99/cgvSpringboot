package com.cgv.models;

public class Schedule {

	private int id;
	private int filmId;
	private String data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Schedule(int id, int filmId, String data) {
		super();
		this.id = id;
		this.filmId = filmId;
		this.data = data;
	}
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", filmId=" + filmId + ", data=" + data + "]";
	}
	
}
