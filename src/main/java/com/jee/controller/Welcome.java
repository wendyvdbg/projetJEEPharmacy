package com.afpa.idp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Welcome extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		System.out.println("dans doGet Welcome");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher ;
		dispatcher = request.getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     
		System.out.println("dans doPost servlet2");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher ;
		dispatcher = request.getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(request, response);
	      
		
	}
	
}