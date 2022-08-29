package com.ppumting.pm80.qna.service;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// db연결에 필요한 값을 불러옴
@WebListener
public class InitializeDataSource implements ServletContextListener {
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/ppumting.properties";
	   public void contextInitialized(ServletContextEvent event)  { 
	        ServletContext context = event.getServletContext();
	        InputStream is = null;
	        try {
	         is = context.getResourceAsStream(JDBC_FILE_PATH);
	         Properties prop = new Properties();
	         prop.load(is);
	         
	         String Driver = prop.getProperty("driver");
	         String Url = prop.getProperty("url");
	         String userName = prop.getProperty("username");
	         String password = prop.getProperty("password");
	         
	         DataSource dataSource = new DataSource(Driver, Url, userName, password);   
	         
	         NamingService namingService = NamingService.getInstance();
	         namingService.setAttribute("dataSource", dataSource);

	         System.out.println("DataSource has been initilized.");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		
	}
}
