package com.ppumting.pm80.qna.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ppumting.pm80.qna.domain.Qna;
import com.ppumting.pm80.qna.service.QnaService;
import com.ppumting.pm80.user.service.Userservice;

@WebServlet("/Qna/qnaInfo/modifyQna.do")
public class findmodifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QnaService service;
	
	public void init() {
		service = new QnaService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Qna qnas = new Qna();
		qnas = service.viewQna(request.getParameter("qnaNo"));
		
		request.setAttribute("qnas", qnas);	// "qnas"(jsp에서 뿌려주는 이름)는 키, qnas는 값
		request.getRequestDispatcher("modifyQna.jsp").forward(request, response);
	}


}
