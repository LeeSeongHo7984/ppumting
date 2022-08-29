package com.ppumting.pm80.note.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ppumting.pm80.note.service.NoteService;

@WebServlet("/Note/deleteSend")
public class noteDeleteSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoteService service = NoteService.getInstance();

    public noteDeleteSendServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		service.deleteSendNote(request.getParameter("no"));
		// 원래는 삭제 후 본인 쪽지함으로 가야하지만 세션 구현이 아직 되어있지 않아 쪽지 쓰기 페이지로 이동
		// 세션 구현시 세션으로 로그인정보 확인 후 자기 쪽지함으로 이동
//		request.getRequestDispatcher("selectTitleMsg.jsp").forward(request, response);
		request.getRequestDispatcher("sendMsg.jsp").forward(request, response);
	}

}
