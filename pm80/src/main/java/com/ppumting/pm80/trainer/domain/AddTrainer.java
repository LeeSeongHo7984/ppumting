package com.ppumting.pm80.trainer.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddTrainer {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ppumting?serverTimezone=Asia/Seoul";
		String id = "ppumting";
		String passwd = "ppumting";
		
		try {
	         Class.forName(driver);
	         System.out.println("LOADED DRIVER ---> " + driver);
	         
	         Connection con = DriverManager.getConnection(url, id, passwd);
	         System.out.println("CONNECTED TO ---> " + url);
	         
	         String sql = "SELECT * FROM Trainer WHERE name=?";
	         PreparedStatement stmt = con.prepareStatement(sql);
	         stmt.setString(1, "홍길동");
	         ResultSet rs = stmt.executeQuery(); //ResultSet -> 실행해서 받아온 결과 //executeQuery -> 쿼리 실행
	         while(rs.next()) {
	            String trainerId = rs.getString("trainerId");
	            String name = rs.getString("name");
	            String ssn = rs.getString("ssn");
	            
	            System.out.println(trainerId);
	            System.out.println(name);
	            System.out.println(ssn);
	            System.out.println("---------------------");
	         }
	         
	         rs.close();
	         stmt.close();
	         con.close();
	         
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         
	      }
	}
}
