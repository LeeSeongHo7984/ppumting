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

@WebServlet("/point/createAccount")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PointService pointService;

	public void init(ServletConfig config) throws ServletException {
		pointService = new PointService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("createAccount.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		List<String> accountNum = new ArrayList<>();
		
		//실패 시 로직 //없는 아이디나 공백을 입력하고 계좌생성 한 경우
		if ( pointService.isValidUser(userId) == false ) {
			request.getRequestDispatcher("createAccountResult/error.jsp").forward(request, response);
			return;
		}
		//이미 계좌를 가지고있는 경우
		if ( pointService.checkAccountNum(userId) != null) { 
			request.getRequestDispatcher("createAccountResult/error2.jsp").forward(request, response);
			return;
		}
		//성공 시 로직
//		accountNum.add(pointService.createAccountNum(userId)); 
//		request.setAttribute("accountNum", accountNum);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("createAccountResult/success.jsp");
//		dispatcher.forward(request, response);
//		
//		HttpSession session = request.getSession(true);
//		session.setAttribute("userId", userId);
//		response.sendRedirect("createAccountResult/success.jsp");
		
		
		
	}

}









