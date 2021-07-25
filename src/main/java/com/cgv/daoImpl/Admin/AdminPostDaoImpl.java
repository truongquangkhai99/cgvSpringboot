package com.cgv.daoImpl.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cgv.dao.Admin.AdminPostDao;
import com.cgv.models.Post;
@Repository
public class AdminPostDaoImpl implements AdminPostDao{
	public static final String GET_ALL="Select * From `post` ORDER BY id DESC";
	public static final String DELETE="Delete From `post` where id = ?";
	public static final String INSERT = "INSERT INTO `post`(`title`, `description`, `image`, `id_cpost`) VALUES (?,?,?,?)";
	public static final String UPDATE = "UPDATE `post` SET `title`=?,`description`=?,`image`=?,`id_cpost`=? WHERE id = ?";
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Override
	public List<Post> getAll(){
		List<Post> list = new ArrayList<Post>();
		list = _jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<>(Post.class));
		return list;
	}
	@Override
	public boolean insert(Post post) {
		int result = _jdbcTemplate.update(INSERT, post.getTitle(),post.getDescription(),post.getImage(),post.getId_cpost());
		if(result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(int id) {
		int result = _jdbcTemplate.update(DELETE, id);
		if(result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean edit(Post post) {
		int result = _jdbcTemplate.update(UPDATE, post.getTitle(),post.getDescription(),post.getImage(),post.getId_cpost(),post.getId());
		if(result == 1) {
			return true;
		}
		return false;
	}
}
