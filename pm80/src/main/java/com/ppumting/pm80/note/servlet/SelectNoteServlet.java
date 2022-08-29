package com.ppumting.pm80.note.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.note.domain.Note;
import com.ppumting.pm80.note.service.NoteService;

@WebServlet("/Note/selectTitleMsg")
public class SelectNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoteService service = NoteService.getInstance();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		List<Note> sendTitles = new ArrayList<>();
		List<Note> receiveTitles = new ArrayList<>();
		
		sendTitles = service.findSendNote(userId);
		receiveTitles = service.findReceiveNote(userId);
		
		long countNote = service.countNote(userId);
		System.out.println(countNote);
		request.setAttribute("countNote", countNote);
		
		request.setAttribute("userId", userId);
		request.setAttribute("sendTitles", sendTitles);
		request.setAttribute("receiveTitles", receiveTitles);
		request.getRequestDispatcher("selectTitleMsg.jsp").forward(request, response);
		
	}

}
