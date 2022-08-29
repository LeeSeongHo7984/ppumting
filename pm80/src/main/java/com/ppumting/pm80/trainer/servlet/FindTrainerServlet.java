package com.ppumting.pm80.trainer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ppumting.pm80.trainer.domain.Trainer;
import com.ppumting.pm80.trainer.service.TrainerService;


@WebServlet("/Trainer/add/findTrainer")
public class FindTrainerServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private TrainerService trainerService = TrainerService.getInstance();
  
   public void init() throws ServletException {
	   super.init();
   }
   
   private static List<Trainer> trainerList;
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      RequestDispatcher dispatcher = null;
      
      trainerList = trainerService.findAllTrainers();

      
      //3. 비즈니스 서비스 호출
      request.setAttribute("trainerList", trainerList);
      
      //4. NextPage
      dispatcher = request.getRequestDispatcher("findTrainer.jsp");
      dispatcher.forward(request, response);
   }


}