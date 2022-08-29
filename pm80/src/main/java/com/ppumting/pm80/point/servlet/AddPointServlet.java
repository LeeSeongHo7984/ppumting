package com.ppumting.pm80.point.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.point.service.PointService;

@WebServlet("/point/addPoint")
public class AddPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PointService pointService;

	public void init(ServletConfig config) throws ServletException {
		pointService = new PointService();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		if (userId == null) { 
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		request.setAttribute("accountNum", pointService.checkAccountNum(userId));
		request.setAttribute("checkPoint", pointService.checkPoint(userId));
		request.getRequestDispatcher("addPoint.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		if (userId == null) { 
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if( request.getParameter("point") == null ) {
			request.setAttribute("msg", "공백 입력 불가");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			return;
		}
		long point = Long.parseLong(request.getParameter("point"));
		
		if( pointService.isValidUser(userId) == false ) {
			request.getRequestDispatcher("addPointResult/error.jsp").forward(request, response);
			return;
		}
		if( pointService.addPoint(userId, point) == false ) {
			request.setAttribute("msg", "충전 실패");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			return;
		}
		
		
		response.sendRedirect("../User/mypage/home");
		
	}


}
