package com.ppumting.pm80.note.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.note.service.NoteService;

@WebServlet("/Note/countNote")
public class CountNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoteService service = NoteService.getInstance();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		long countNote = service.countNote(userId);
//		System.out.println(countNote);
		request.setAttribute("countNote", countNote);
		request.getRequestDispatcher("/User/mypage/home").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/User/mypage/home").forward(request, response);
		
	}

}
