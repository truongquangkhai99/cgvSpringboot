package com.cgv.controllers.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgv.models.Rating;
import com.cgv.models.ResponseAjax;
import com.cgv.models.User;
import com.cgv.serviceImpl.User.CommentServiceImpl;

@Controller
@RequestMapping("/user")
public class CommentController {
	
	@Autowired
	public CommentServiceImpl commentService;
	
	
	@PostMapping("/comment")
	public @ResponseBody ResponseAjax comment(HttpServletRequest request) {
		ResponseAjax rA = new ResponseAjax();
		String idFilm = request.getParameter("idFilm");
		String textComment = request.getParameter("textComment");	
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Rating rating = new Rating();
		
		if(textComment.isEmpty()) {
			rA.setStatus("ErrorEmpty");
			rA.setMessage("❌  Cần điền lời muốn bình luận");
		}else {
			if(user == null) {
				rA.setStatus("ErrorLogin");
				rA.setMessage("❌ Bạn cần phải đăng nhập");
			}else {
				rating.setUserId(user.getId());
				rating.setFilmId(Integer.parseInt(idFilm));
				rating.setRate(textComment);
				rating.setName_user(user.getUsername());
				boolean result = commentService.comment(rating);
				if(result) {
					List<Rating> listR = commentService.getCommentById(Integer.parseInt(idFilm));
					rA.setData(listR);
					rA.setStatus("Success");
					rA.setMessage("Thành công");
				}else {
					rA.setStatus("Error");
					rA.setMessage("❌ Thất bại");
				}
			}
		
		}
		return rA;
	}

}
