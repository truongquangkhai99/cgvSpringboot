package com.cgv.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cgv.models.User;

public class MiddleWare {
	public boolean checkAdminLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userAdmin = (User)session.getAttribute("userAdmin");
		if(userAdmin == null) {
			return false;
		}else {
			return true;
		}
	}
}
