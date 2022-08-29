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

@WebServlet("/point/checkPoint")
public class CheckPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PointService pointService;

	public void init(ServletConfig config) throws ServletException {
		pointService = new PointService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("checkPoint.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId"); 
		List<String> successPrice = new ArrayList<>();

		// 실패 시 로직
		if (pointService.checkPoint(userId) == null || pointService.checkPoint(userId).length() == 0) {
			request.getRequestDispatcher("checkPointResult/error.jsp").forward(request, response);
			return;
		}
		// 성공 시 로직
		successPrice.add(pointService.checkPoint(userId));
		request.setAttribute("successPrice", successPrice);
		RequestDispatcher dispatcher = request.getRequestDispatcher("checkPointResult/success.jsp");
		dispatcher.forward(request, response);

		HttpSession session = request.getSession(true);
		session.setAttribute("userId", userId);
		response.sendRedirect("checkPointResult/success.jsp");

	}

}
