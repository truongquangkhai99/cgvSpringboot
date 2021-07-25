package com.cgv.controllers.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgv.models.CategoryPost;
import com.cgv.models.Post;
import com.cgv.models.Room;
import com.cgv.serviceImpl.Admin.AdminRoomServiceimpl;
import com.cgv.utils.MiddleWare;

@Controller
@RequestMapping("/admin")
public class RoomAdminController {
	@Autowired
	public AdminRoomServiceimpl adminRoomServiceimpl;
	@GetMapping("/phong")
	public ModelAndView phong(HttpServletRequest request) {
		MiddleWare middleWare = new MiddleWare();
		ModelAndView mv = new ModelAndView();
		boolean check = middleWare.checkAdminLogin(request);
		if(check) {
			 mv = new ModelAndView("admin/phong");
			List<Room> list = adminRoomServiceimpl.getAll();
			mv.addObject("list",list);
		}else {
			mv = new ModelAndView("redirect:login");
		}
		
		return mv;
	}
	@PostMapping("/delete-room")
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:phong");
		String id= request.getParameter("id");
		boolean result = adminRoomServiceimpl.delete(Integer.parseInt(id));
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/add-room")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:phong");
		String name= request.getParameter("name");
		Room room = new Room();
		room.setRoomName(name);
		boolean result = adminRoomServiceimpl.insert(room);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
	@PostMapping("/update-room")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:phong");
		String name= request.getParameter("name");
		String id= request.getParameter("id");
		Room room = new Room();
		room.setRoomName(name);
		room.setId(Integer.parseInt(id));
		boolean result = adminRoomServiceimpl.edit(room);
		if(result) {
			System.out.println("Thành công");
		}
		else {
			System.err.println("Thất bại");
		}
		return mv;
	}
}
