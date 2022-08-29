package com.ppumting.pm80.note.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ppumting.pm80.note.domain.Note;
import com.ppumting.pm80.note.service.NoteService;

@WebServlet("/Note/notemsg")
public class SelectNoteMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoteService service = NoteService.getInstance();

	public SelectNoteMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Note rcvNotes = new Note();
		Note sendNotes = new Note();
		rcvNotes = service.viewRcvMsg(request.getParameter("no"));
		sendNotes = service.viewSendMsg(request.getParameter("no"));
		request.setAttribute("rcvNotes", rcvNotes);
		request.setAttribute("sendNotes", sendNotes);
		request.getRequestDispatcher("notemsg.jsp").forward(request, response);
	}
}
