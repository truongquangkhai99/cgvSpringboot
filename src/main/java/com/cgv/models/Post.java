package com.cgv.models;

public class Post {
	private int id;
	private String title;
	private String description;
	private String image;
	private String created_at;
	private int id_cpost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getId_cpost() {
		return id_cpost;
	}
	public void setId_cpost(int id_cpost) {
		this.id_cpost = id_cpost;
	}
	public Post() {
		super();
	}
	public Post(int id, String title, String description, String image, String created_at, int id_cpost) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.created_at = created_at;
		this.id_cpost = id_cpost;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", created_at=" + created_at + ", id_cpost=" + id_cpost + "]";
	}
	
	

}
