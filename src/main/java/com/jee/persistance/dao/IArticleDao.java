package com.jee.persistance.dao;

import com.jee.persistance.beanDo.ArticleDo;

public interface IArticleDao {
	
	/**
	 * Permet de creer un articleDo
	 * 
	 * @param articleDo
	 * @return articleDo
	 */
	ArticleDo create(final ArticleDo articleDo);

}
