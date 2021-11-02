package com.jee.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jee.model.Article;

public class ArticleDaoImpl implements ArticleDao {
	private DaoFactory daoFactory;

	ArticleDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Article article) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("INSERT INTO public.articles(title, quantity, price)VALUES (?, ?, ?);");
			preparedStatement.setString(1, article.getTitle());
			preparedStatement.setInt(2, article.getQuantity());
			preparedStatement.setDouble(3, article.getPrice());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Article> lister() {
		List<Article> articles = new ArrayList<Article>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM articles;");

			while (resultat.next()) {
				Article article = new Article(resultat.getInt("id"),resultat.getString("title"), resultat.getInt("quantity"),
						resultat.getDouble("price"));
				articles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	public Article trouver(int id) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		Article article = new Article();
		ResultSet resultat;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("SELECT * FROM articles WHERE id= ?;");
			preparedStatement.setInt(1, id);
			resultat = preparedStatement.executeQuery();
			article.setId(resultat.getInt("id"));
			article.setTitle(resultat.getString("title"));
			article.setQuantity(resultat.getInt("quantity"));
			article.setPrice(resultat.getDouble("price"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
		
	}
	// todo cr�er une nouvelle fonction supprim�, qui prend en param�tre un ID d'article
	public void supprimer(int id) {
		
		
	}

}