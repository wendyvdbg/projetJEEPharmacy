package com.jee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.ArticleDao;
import com.jee.dao.DaoFactory;
import com.jee.model.Article;

/**
 * Servlet implementation class ArticleForm
 */
@WebServlet("/ArticleForm")
public class ArticleForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao articleDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	   public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.articleDao = daoFactory.getArticleDao();
	    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/articleForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean success = true;
		String title;
		int quantity;
		double price;
		Article article = null;
		try {
			title = request.getParameter("title");
			quantity = Integer.parseInt(request.getParameter("quantity"));
			price = Double.parseDouble(request.getParameter("price"));
			article = new Article(title, quantity, price);
			
		} catch (NumberFormatException e) {
			success = false;
			request.setAttribute("erreurCreation", "Merci de fournir un chiffre correct");
		} catch (Exception e) {
			success = false;
			request.setAttribute("erreurCreation", "impossible de cr�er l'article");
		}
		if(success) {
			articleDao.ajouter(article);
			request.setAttribute("successCreation", success);
			request.setAttribute("article", article);
		}
		request.setAttribute("articles", articleDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/articles.jsp").forward(request, response);
	}

}
