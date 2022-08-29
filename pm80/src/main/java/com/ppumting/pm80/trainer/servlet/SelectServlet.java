package com.ppumting.pm80.trainer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ppumting.pm80.trainer.service.TrainerService;

@WebServlet("/Trainer/update/trainerSelect")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TrainerService trainerService;
	
	public void init() {
		trainerService = new TrainerService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String trainerId = request.getParameter("trainerId");
		RequestDispatcher dispatcher = null;
		if(trainerService.checkTrainer(trainerId)) {
			request.setAttribute("trainer", trainerService.trainerSelect(trainerId));
			dispatcher = request.getRequestDispatcher("updatetrainer.jsp");
			dispatcher.forward(request, response);
		}
		else {
			dispatcher = request.getRequestDispatcher("updatefailure.jsp");
			dispatcher.forward(request, response);
			return;
		}	
	}
}