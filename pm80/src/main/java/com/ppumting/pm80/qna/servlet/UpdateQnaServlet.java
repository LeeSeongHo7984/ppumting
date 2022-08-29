package com.ppumting.pm80.qna.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ppumting.pm80.qna.domain.Qna;
import com.ppumting.pm80.qna.service.QnaService;

@WebServlet("/Qna/qnaInfo/update.do")
public class UpdateQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QnaService service;
	
    public void init() {
    	service = new QnaService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String qnaNo = request.getParameter("qna_no");
		String qnaTitle = request.getParameter("qna_title");
		String qnaContent = request.getParameter("qna_content");
		System.out.println(qnaNo);
		System.out.println(qnaTitle);
		System.out.println(qnaContent);
		List<String> errorMsgs = new ArrayList<>();
		
		if(qnaTitle == null || qnaTitle.length() == 0) {
			errorMsgs.add("제목을 입력해주세요");
		}else if(qnaContent == null || qnaContent.length() == 0) {
			errorMsgs.add("내용을 입력해주세요");
		}
		
		Qna qna = new Qna();
		qna.setQnaNo(qnaNo);
		qna.setQnaTitle(qnaTitle);
		qna.setQnaContent(qnaContent);
		
		service.updateQna(qna);
		request.setAttribute("qna", qna);
		request.getRequestDispatcher("updateQna.jsp").forward(request, response);
	}

}
