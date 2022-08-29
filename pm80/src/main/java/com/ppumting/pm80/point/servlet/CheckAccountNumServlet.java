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

@WebServlet("/point/checkAccountNum")
public class CheckAccountNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PointService pointService;

	public void init(ServletConfig config) throws ServletException {
		pointService = new PointService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("checkAccountNum.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId"); // DB에서 조회하려고 받아온 ID
		List<String> accountNum = new ArrayList<>();
		
		//실패 시 로직
		if ( pointService.isValidUser(userId) == false ) {
			request.getRequestDispatcher("checkAccountNumResult/error.jsp").forward(request, response);
			return;
		}
		//성공 시 로직
		if( pointService.checkAccountNum(userId) != null) {
			accountNum.add(pointService.checkAccountNum(userId));
			request.setAttribute("accountNum", accountNum);
			RequestDispatcher dispatcher = request.getRequestDispatcher("checkAccountNumResult/success.jsp");
			dispatcher.forward(request, response);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", userId);
			response.sendRedirect("checkAccountNumResult/success.jsp");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("checkAccountNumResult/success2.jsp");
			dispatcher.forward(request, response);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", userId);
//			response.sendRedirect("checkAccountNumResult/success2.jsp");
		}
		
		
	}

}