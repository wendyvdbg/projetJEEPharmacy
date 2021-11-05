package com.jee.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("Je suis dans dopost");
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://localhost/idp_services";
		final String USER = "root";
		final String PASS = "";
		
		String userlog;
		String userpass;
		String returnedpass = "";
		int compteur = 0;	
		boolean connect = false;
		
		Connection conn = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");


		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		
		//Scanner saisie = new Scanner(System.in);

		// saisie des identifiants par l'utilisateur

			//System.out.println("Saisir votre username: ");
			userlog = request.getParameter("login"); //saisie.nextLine();
			
			//System.out.println("Saisir votre password: ");
			userpass = request.getParameter("password");//saisie.nextLine();

			ResultSet rs;
			
			String query = "SELECT pwd FROM user WHERE userName = '" + userlog + "'"; // r�cup�re le password li� au login dans la BDD
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next())
			{
				returnedpass = rs.getString("pwd");
				//System.out.println(returnedpass);
			}
			

			if (returnedpass.equals(userpass)) { // Si le mot de passe correspond (case sensitive)

				//Autoriser la connexion
				//programme Dorian, "consulter" ou "souscrire"
				System.out.println("Vous �tes connect� !");
				connect = true;
				

			} else { // Si un des deux identifiants n'est pas reconnu

				//Refuser la connexion
				System.out.println("Votre identifiant et/ou mot de passe est incorrect.");
				connect = false;
				compteur ++;

				if(compteur == 3) { // Si trois �checs, cherche l'email li� au login

					
					String query2 = "SELECT mail FROM client WHERE EXISTS ( SELECT userName FROM user WHERE userName = '" + userlog + "')";
					Statement stmt2 = conn.createStatement();
					ResultSet rs2 = stmt2.executeQuery(query2);

					String mailuser = "";
					if (rs2.next()) // Si le mail existe
					{
						mailuser = rs2.getString("mail");
						System.out.println("Vous avez �chou� trois fois. Nous vous avons envoy� un email pour r�initialiser votre mot de passe si vous l'avez oubli�.");
						//appeler m�thode envoi de mail, adresse mail de l'utilisateur = mailuser
					} else { // Si le login n'est pas dans la base de donn�es

						System.out.println("Votre login n'est pas reconnu, merci de v�rifier que vous avez un compte utilisateur ou de le cr�er si besoin.");
					}
					
				}
			} 
		
		//saisie.close();
		
		st.close();
		conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (connect == true) {
		RequestDispatcher dispatcher ;
		dispatcher = request.getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher ;
			dispatcher = request.getRequestDispatcher("/page2.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
