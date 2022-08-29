package com.ppumting.pm80.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.user.domain.User;
import com.ppumting.pm80.user.service.Userservice;

@WebServlet("/User/mypage/userUpdate/userSelect")
public class UserSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Userservice userService;
	
	public void init() {
		userService = new Userservice();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");

		
		if(userService.checkUser(userId)) {
			request.setAttribute("user", userService.userSelect(userId));
			request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
		}
			
	}
		
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
}
}