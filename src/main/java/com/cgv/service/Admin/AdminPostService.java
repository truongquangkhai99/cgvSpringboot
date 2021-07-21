package com.cgv.service.Admin;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cgv.models.Post;

@Service
public interface AdminPostService {
	public List<Post> getAll();
	
	public boolean insert(Post post);
	
	public boolean delete(int id);
	
	public boolean edit(Post id);
}
