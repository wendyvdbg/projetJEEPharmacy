package com.jee.dao;

import java.util.List;

import com.jee.model.Article;

public interface ArticleDao {
	    List<Article> lister();
		void ajouter(Article article);
		// todo : ajouter supprimer
}
