package com.ppumting.pm80.qna.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.point.service.PointService;
import com.ppumting.pm80.qna.domain.Qna;
import com.ppumting.pm80.qna.service.QnaService;

@WebServlet("/Qna/qnaInfo/find.do")
public class QnaFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QnaService qnaService = QnaService.getInstance();
	private PointService pointService = new PointService();
	
	public void init() throws ServletException {
		super.init();
	}

	private static List<Qna> qnaList; 
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		String checkPoint = pointService.checkPoint(userId);
		
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispacher = null;
		
		qnaList = qnaService.getfindNoQna();
		
		request.setAttribute("checkPoint", checkPoint);
		request.setAttribute("qnaList", qnaList);
//		System.out.println("실행됨");
		
		dispacher = request.getRequestDispatcher("findQna.jsp");
		dispacher.forward(request, response);
//		System.out.println("성공");
	}

}
