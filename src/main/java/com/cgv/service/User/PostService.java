package com.cgv.service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgv.models.Post;

@Service
public interface PostService {
	public List<Post> getPromotion();
	public List<Post> getInfor();
	public Post getDetail(int id);
	
}
