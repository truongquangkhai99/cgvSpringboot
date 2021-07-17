package com.cgv.models;

public class CategoryFilm {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryFilm(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CategoryFilm() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoryFilm [id=" + id + ", name=" + name + "]";
	}
	
}
