package com.cgv.models;

public class Schedule {

	private int id;
	private int filmId;
	private String date;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Schedule(int id, int filmId, String date) {
		super();
		this.id = id;
		this.filmId = filmId;
		this.date = date;
	}
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", filmId=" + filmId + ", date=" + date + "]";
	}
	
	

	
}
