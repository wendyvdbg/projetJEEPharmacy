package com.jee.persistance.dao.imp;

import org.hibernate.SessionFactory;

import com.jee.persistance.beanDo.ArticleDo;
import com.jee.persistance.dao.IArticleDao;
import com.jee.persistance.factory.HibernateFactory;

public class ArticleDaoImpl implements IArticleDao {

	 // on peut mettre la sessionFactory en attribut
    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

	@Override
	public ArticleDo create(ArticleDo articleDo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}