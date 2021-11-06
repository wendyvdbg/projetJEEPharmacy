package com.jee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jee.dao.ArticleDao;
import com.jee.dao.DaoFactory;
import com.jee.dao.UserDao;
import com.jee.model.Article;
import com.jee.model.User;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private ArticleDao articleDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.userDao = daoFactory.getUserDao();
		this.articleDao = daoFactory.getArticleDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean connected = false;
		User user = null;
		HttpSession session = request.getSession();
		if (request.getParameter("deconnexion") != null) {
			session.setAttribute("connected", false);
			request.setAttribute("errorLogin", false);
			this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request,
					response);
			return;
		}
		try {
			user = userDao.login(request.getParameter("email"), request.getParameter("password"));
			if (user.getEmail() != null) {
				connected = true;
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		session.setAttribute("connected", connected);
		if (connected) {
			request.setAttribute("articles", articleDao.lister());
			this.getServletContext().getRequestDispatcher("/WEB-INF/articles.jsp").forward(request, response);
		} else {
			request.setAttribute("errorLogin", true);
			this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request, response);
		}
	}

}
