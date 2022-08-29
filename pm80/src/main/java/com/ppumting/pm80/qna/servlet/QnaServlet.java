package com.ppumting.pm80.qna.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.qna.domain.Qna;
import com.ppumting.pm80.qna.service.QnaService;

@WebServlet("/Qna/qnaInfo/add_qna.do")
public class QnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QnaService qnaService = QnaService.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		String qnaTitle = request.getParameter("qna_title");
		String qnaContent = request.getParameter("qna_content");
		
		List<String> errorMsgs = new ArrayList<>();
		if ( qnaTitle == null || qnaTitle.length() == 0) {
			errorMsgs.add("제목을 입력해 주세요");
		} else if ( qnaContent == null || qnaContent.length() == 0 ) {
			errorMsgs.add("내용을 입력해 주세요");
		}
		
		RequestDispatcher dispatcher = null;
		if(errorMsgs.size() > 0 ) {
			dispatcher = request.getRequestDispatcher("/Qna/qnaInfo/error.jsp");
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher.forward(request, response);
			return ;
		}
		
		Qna qna = new Qna();
		qna.setUserId(userId);
		qna.setQnaTitle(qnaTitle);
		qna.setQnaContent(qnaContent);
		qnaService.addQna(qna);
		request.setAttribute("qna", qna);
		System.out.println(userId);
		response.sendRedirect("find.do");
	}
}
