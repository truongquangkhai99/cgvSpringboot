package com.cgv.models;

public class Film {
	private int id;
	private String description;
	private String director;
	private String actor;
	private String duration;
	private String filmName;
	private String image;
	private String trailer;
	private int id_cfilm;
	public int getId_cfilm() {
		return id_cfilm;
	}
	public void setId_cfilm(int id_cfilm) {
		this.id_cfilm = id_cfilm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public Film(int id, String description, String director, String actor, String duration, String filmName,
			String image, String trailer, int id_cfilm) {
		super();
		this.id = id;
		this.description = description;
		this.director = director;
		this.actor = actor;
		this.duration = duration;
		this.filmName = filmName;
		this.image = image;
		this.trailer = trailer;
		this.id_cfilm = id_cfilm;
	}
	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", description=" + description + ", director=" + director + ", actor=" + actor
				+ ", duration=" + duration + ", filmName=" + filmName + ", image=" + image + ", trailer=" + trailer
				+ ", categoryFilmId=" + id_cfilm + "]";
	}
	

}
