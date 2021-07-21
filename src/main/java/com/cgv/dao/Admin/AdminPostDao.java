package com.cgv.dao.Admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgv.models.Post;

@Repository
public interface AdminPostDao {
	public List<Post> getAll();
	
	public boolean insert(Post post);
	
	public boolean delete(int id);
	
	public boolean edit(Post id);
}
