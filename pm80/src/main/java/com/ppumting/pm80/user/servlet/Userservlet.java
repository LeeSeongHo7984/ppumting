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

import com.ppumting.pm80.point.service.PointService;
import com.ppumting.pm80.user.domain.User;
import com.ppumting.pm80.user.service.Userservice;

@WebServlet("/User/mypage/addUser/addUser")
public class Userservlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	Userservice userService;
	PointService pointService;
	
	public void init() {
		userService = new Userservice();
		pointService = new PointService();
	}
		
	//회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String phone = request.getParameter("phone");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		List<String> errorMsgs = new ArrayList<>();
		if(userId == null || userId.length() == 0) {
			errorMsgs.add("id를 입력해주세요,");		
		}else if(pw == null || pw.length() == 0) {
			errorMsgs.add("비밀번호를 입력해주세요");
		}else if(name == null || name.length() == 0) {
			errorMsgs.add("이름을 입력해주세요");
		}else if(ssn == null || ssn.length() == 0) {
			errorMsgs.add("주민번호를 입력해주세요");
		}else if(phone == null || phone.length() == 0) {
			errorMsgs.add("전화번호를 입력해주세요");
		}else if(addr1 == null || addr1.length() == 0 || 
				addr2 == null || addr2.length() == 0) {
			errorMsgs.add("주소를 입력해주세요");
		}
		
		RequestDispatcher dispatcher = null;
		if(errorMsgs.size() > 0) {
			dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher.forward(request, response);
			return;
		}

		
		User user = new User();
		user.setUserId(userId);
		user.setPw(pw);
		user.setName(name);
		user.setSsn(ssn);
		user.setPhone(phone);
		user.setAddr(addr1+ " " + addr2);
		Userservice userService = new Userservice();
		userService.addUser(user);
		pointService.createAccountNum(userId);
		request.setAttribute("user", user);
		response.sendRedirect("../loginout/login");
		return;
	}
}