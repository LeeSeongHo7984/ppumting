package com.ppumting.pm80.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.point.service.PointService;
import com.ppumting.pm80.user.service.Userservice;

@WebServlet("/User/mypage/delete/deleteUser")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  Userservice userService;
	private PointService pointService;
	
	public void init() {
		userService = new Userservice();
		pointService = new PointService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession(false);
			String userId = (String) session.getAttribute("userId");

			String pw = request.getParameter("pw");
			String ssn = request.getParameter("ssn");
			pointService.deleteAccount(userId);
			userService.delete(userId, pw, ssn);
			
			session.setAttribute("userId", userId);
			response.sendRedirect("../loginout/login");
	}
	
}
