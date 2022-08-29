     package com.ppumting.pm80.user.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.note.service.NoteService;
import com.ppumting.pm80.point.service.PointService;
import com.ppumting.pm80.user.service.Userservice;

@WebServlet("/User/mypage/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Userservice userService;
	private PointService pointService;
	private NoteService service = NoteService.getInstance();

	public void init() {
		userService = new Userservice();
		pointService = new PointService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		String checkPoint = pointService.checkPoint(userId);
		
		long countNote = service.countNote(userId);
		
		if (userId == null) { //세션 ID가 유지가 안됬을때 로그인 화면으로 보냄
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("checkPoint", checkPoint);
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + ": " + cookie.getValue());
			if (cookie.getName().equals("lastAccessTime")) {
				request.setAttribute("lastAccessTime", URLDecoder.decode(cookie.getValue(), "UTF-8"));
			}
		}
		response.addCookie(lastAccessTime());
		
		request.setAttribute("countNote", countNote);

		request.getRequestDispatcher("home.jsp").forward(request, response);
		request.getRequestDispatcher("banner.jsp").forward(request, response);
	}

	private Cookie lastAccessTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date());
		Cookie cookie = null;

		try {
			cookie = new Cookie("lastAccessTime", URLEncoder.encode(dateStr, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		cookie.setMaxAge(60 * 60 * 24 * 30);
		cookie.setPath("/");
		return cookie;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		String userId = request.getParameter("userId");
//		
//		// 세션 주는 코드
//		HttpSession session = request.getSession(true);
//		session.setAttribute("userId", userId);
//		session.setAttribute("user", userService.userSelect(userId));
//		response.sendRedirect("userUpdate");
//		response.sendRedirect("addPoint");
//		response.sendRedirect("add_qna.do");
	}
}
