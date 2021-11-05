package com.afpa.idp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
 */
//@WebServlet("/welcomee.do")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("\n------------\n-----------coucou init servlet");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dans goGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nom = request.getParameter("nom");
		
		System.out.println("nom : " + nom);
		String prenom = request.getParameter("prenom");
		System.out.println("prenom :" +prenom);
		String mail = request.getParameter("mail");
		System.out.println("Mail :" +mail);
		String phone  = request.getParameter("phone");
		System.out.println("phone :" +phone);
		String date   = request.getParameter("Date de naissance");
		System.out.println("Date de naissance :" +date);
		String adresse  = request.getParameter("Adresse");
		System.out.println("Adresse :" + adresse);
		String postal  = request.getParameter("code postal");
		System.out.println("code postal :" + postal);
		String pays  = request.getParameter("Pays");
		System.out.println("Pays :" +pays);
		String ident  = request.getParameter("identifiant");
		System.out.println("indentifiant :" +ident);
		String pswd  = request.getParameter("mot de passe");
		System.out.println("mot de passe :" +pswd);
		String conf  = request.getParameter("confirmation ");
		System.out.println("confirmation du mot de passe :" +conf);
		
		
		
		
		
		
		RequestDispatcher dispatcher ;
		dispatcher = request.getRequestDispatcher("authenticate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("dans goPost");
		doGet(request, response);
	}

}