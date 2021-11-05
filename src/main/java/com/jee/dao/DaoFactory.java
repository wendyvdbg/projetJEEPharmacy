package com.jee.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
                "jdbc:postgresql://localhost:5432/Pharmacy", "postgres", "user");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public ArticleDao getArticleDao() {
        return new ArticleDaoImpl(this);
    }
    
    public UserDao getUserDao() {
        return new UserDaoImpl(this);
    }
}