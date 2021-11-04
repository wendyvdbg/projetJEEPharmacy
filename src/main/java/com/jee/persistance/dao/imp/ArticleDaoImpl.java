package com.jee.persistance.dao.imp;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.jee.persistance.beanDo.ArticleDo;
import com.jee.persistance.dao.IArticleDao;
import com.jee.persistance.factory.HibernateFactory;

public class ArticleDaoImpl implements IArticleDao {

	 // on peut mettre la sessionFactory en attribut
    private SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

	@Override
	public ArticleDo create(final ArticleDo articleDo) {
		 try (final Session session = sessionFactory.openSession()) {

	            // sans auto-commit, on doit cr�er une transaction
			 final Transaction transaction = session.beginTransaction();

	            session.save(articleDo);
	            session.flush();

	            // et la commiter manuellement
	            transaction.commit();

	            // en cas d'erreur :
	            // transaction.rollback();

	            return articleDo;
	        } catch (final HibernateException hibernateException) {
	            // on peut catcher des HibernateException
	            hibernateException.printStackTrace();

	        }
		return null;
	}

	@Override
	public ArticleDo find(Integer idArticleDo) {
		 try (final Session session = sessionFactory.openSession()) {
	            final Transaction transaction = session.beginTransaction();
	            final Query<ArticleDo> query = session.createQuery("From ArticleDo where id = :idParam", ArticleDo.class);
	            // on initialise le param�tre
	            query.setParameter("idParam", idArticleDo);
	            // regarder la Javadoc de Optional
	            final Optional<ArticleDo> articleDo = query.uniqueResultOptional();

	            session.flush();
	            transaction.commit();
	            // suite de la feature Optional de Java 8
	            return articleDo.orElse(null);
	        } catch (final HibernateException hibernateException) {
	            // on peut catcher des HibernateException
	            hibernateException.printStackTrace();
	        }
		return null;
	}

	@Override
	public List<ArticleDo> findAll() {
		try (final Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Query<ArticleDo> query = session.createQuery("From ArticleDo ", ArticleDo.class);
            final List<ArticleDo> listeProduitsDo = query.getResultList();

            session.flush();
            transaction.commit();
            return listeProduitsDo;
        } catch (final HibernateException hibernateException) {
            // on peut catcher des HibernateException
            hibernateException.printStackTrace();
        }
        return new ArrayList<>();
	}

	@Override
	public ArticleDo update(Integer idArticleDo, ArticleDo articleDo) {
		try (final Session session = sessionFactory.openSession()) {

            // sans auto-commit , on doit cr�er une transaction
            final Transaction transaction = session.beginTransaction();

            final Query<?> query = session.createQuery("update ArticleDo set title = :title where id = :idArticleDo");
            // intialisation des param�tres
            query.setParameter("title", articleDo.getTitle());
            query.setParameter("quantity", articleDo.getQuantity());
            query.setParameter("price", articleDo.getPrice());
            query.setParameter("idArticleDo", idArticleDo);
            query.executeUpdate();

            // on "compl�te" le Do � retourner
            articleDo.setId(idArticleDo);

            session.flush();
            transaction.commit();
            return articleDo;
        } catch (final HibernateException hibernateException) {
            // on peut catcher des HibernateException
            hibernateException.printStackTrace();
        }
		return null;
	}

	@Override
	public boolean delete(Integer idArticleDo) {
		try (final Session session = sessionFactory.openSession()) {

            // sans auto-commit, on doit cr�er une transaction
            final Transaction transaction = session.beginTransaction();

            // delete avec query
            final Query<?> query = session.createQuery("delete from ArticleDo where id = :idArticleDo");
            query.setParameter("idArticleDo", idArticleDo);
            final int result = query.executeUpdate();
            // Attention, la Query ne g�re pas le cascading !

            // delete sans query
            //            final ArticleDo articleDo = session.load(ArticleDo.class, idArticleDo);
            //            session.delete(articleDo);

            session.flush();
            transaction.commit();

            return result == 1;
        } catch (final HibernateException | EntityNotFoundException exception) {
            // on peut catcher des HibernateException ou des EntityNotFoundException pour le session.delete
            exception.printStackTrace();
        }
        return false;
	}

	
}