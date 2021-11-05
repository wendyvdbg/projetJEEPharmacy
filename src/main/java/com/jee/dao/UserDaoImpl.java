package com.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jee.model.Article;
import com.jee.model.User;

public class UserDaoImpl implements UserDao{

	private DaoFactory daoFactory;

	UserDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public User login(String email, String password) {
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		User user = new User();
		ResultSet resultat;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM public.user WHERE email= ?;");
			preparedStatement.setString(1, email);
			resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				user.setEmail(resultat.getString("email"));
				user.setNom(resultat.getString("nom"));
				user.setPrenom(resultat.getString("prenom"));
				user.setPassword(resultat.getString("password"));
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}
}
