package com.ppumting.pm80.trainer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.point.service.PointService;
import com.ppumting.pm80.trainer.service.TrainerService;

@WebServlet("/Trainer/mypage")
public class MyPageTrainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PointService pointService = new PointService(); 
	
	public void init() {
		new TrainerService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String trainerId = (String)session.getAttribute("trainerId");
		String userId = (String) session.getAttribute("userId");
		String checkPoint = pointService.checkPoint(userId);
		
		request.setCharacterEncoding("UTF-8");
		
		// 여기때매 PPT에 안들어가져서 잠시 주석해뒀음 -존잘상규-
//		if(trainerId == null) {
//			request.getRequestDispatcher("/loginout/login.jsp").forward(request, response);
//			return;
//		}
		request.setAttribute("checkPoint", checkPoint);
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("minusPoint");
	}
	
}
