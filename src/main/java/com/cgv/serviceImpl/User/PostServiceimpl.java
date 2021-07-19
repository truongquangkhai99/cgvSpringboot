package com.cgv.serviceImpl.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgv.dao.User.PostDao;
import com.cgv.models.Post;
import com.cgv.service.User.PostService;

@Service
public class PostServiceimpl implements PostService{
	@Autowired
	public PostDao postDao;
	@Override
	public List<Post> getPromotion(){
		return postDao.getPromotion();
	}
	@Override
	public List<Post> getInfor(){
		return postDao.getInfor();
	}
	@Override
	public Post getDetail(int id) {
		return postDao.getDetail(id);
	}
}
