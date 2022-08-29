package com.ppumting.pm80.user.servlet;

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

import com.ppumting.pm80.user.domain.User;
import com.ppumting.pm80.user.service.Userservice;

@WebServlet("/User/mypage/userUpdate/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Userservice userService;
	
	public void init() {
		userService = new Userservice();
	}
	
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
		
		String userId = request.getParameter("userId");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("userId", userId);
		response.sendRedirect("../home");
		
		
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");

		List<String> errorMsgs = new ArrayList<>();
		
		if(pw == null || pw.length() == 0) {
			errorMsgs.add("비밀번호를 입력해주세요");
		}else if(name == null || name.length() == 0) {
			errorMsgs.add("이름을 입력해주세요");
		}else if(phone == null || phone.length() == 0) {
			errorMsgs.add("전화번호를 입력해주세요");
		}else if(addr == null || addr.length() == 0) {
			errorMsgs.add("주소를 입력해주세요");
		}
		
		User user = new User();
		user.setUserId(userId);
		user.setPw(pw);
		user.setName(name);
		user.setPhone(phone);
		user.setAddr(addr);
		
		userService.updateUser(user);
		request.setAttribute("user", user);
	}
}