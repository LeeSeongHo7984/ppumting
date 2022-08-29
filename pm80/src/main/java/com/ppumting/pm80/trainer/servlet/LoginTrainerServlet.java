package com.ppumting.pm80.trainer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppumting.pm80.trainer.domain.Trainer;
import com.ppumting.pm80.trainer.service.TrainerService;

@WebServlet("/Trainer/loginout/admin")
public class LoginTrainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TrainerService trainerService;
	
	public void init() {
		trainerService = new TrainerService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("admin.jsp").forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String trainerId = request.getParameter("trainerId");
		String passwd = request.getParameter("passwd");
		
		
//		Trainer dbtrainer = new Trainer();
//		if(dbtrainer.getTrainerId().equals(request.getParameter("root"))&&
//				dbtrainer.getPasswd().equals(request.getParameter("root"))) {
//			System.out.println("admin login");
//			response.sendRedirect("../mypage.jsp");
//			return;
//		}else {
//			request.getRequestDispatcher("error.jsp").forward(request, response);
//			return ;
//		}
		
		
		if(trainerService.login(trainerId, passwd)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("trainerId", trainerId);
			response.sendRedirect("../mypage.jsp");
			System.out.println("admin login");
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return ;
		}
		
	}

}
