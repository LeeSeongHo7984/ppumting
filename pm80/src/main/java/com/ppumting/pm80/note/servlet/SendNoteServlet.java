package com.ppumting.pm80.note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.note.domain.Note;
import com.ppumting.pm80.note.service.NoteService;

@WebServlet("/Note/sendMsg")
public class SendNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private NoteService service = NoteService.getInstance();
	
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String msg = request.getParameter("msg");
		String receiveUserId = request.getParameter("receiveUserId");
		HttpSession session = request.getSession(false);
		String sendUserId = (String) session.getAttribute("userId");
		
		Note note = new Note();
		
		note.setTitle(title);
		note.setMsg(msg);
		note.setReceiveUserId(receiveUserId);
		note.setSendUserId(sendUserId);
		service.sendNote(note);
		
		request.getRequestDispatcher("close.jsp").forward(request, response);
	}

}
