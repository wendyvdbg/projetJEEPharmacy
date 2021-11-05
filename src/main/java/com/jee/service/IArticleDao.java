package com.jee.service;

import com.jee.model.ArticleDo;

import java.util.List;



public interface IArticleDao {

	/**
	 * Permet de creer un articleDo
	 *
	 * @param articleDo
	 * @return articleDo
	 */
	ArticleDo create(final ArticleDo articleDo);

	/**
     * Permet de rechercher un article selon son Id
     *
     * @param idArticleDo  l'id du article � rechercher
     * @return le article recherch�, null sinon
     */
	ArticleDo find(final Integer idArticleDo );

    /**
     * Permet de retrouver tous les articles
     *
     * @return la liste de tous les articles, vide ou remplie
     */
    List<ArticleDo> findAll ();

    /**
     * Permet de mettre � jour un article
     *
     * @param articleDo  le article
     * @return le article mis � jour, null en cas de probl�me
     */
    ArticleDo update( final ArticleDo articleDo);

    /**
     * Permet de supprimer un article selon son id
     *
     * @param idArticleDo  l'id du article � supprimer
     * @return true si OK, false sinon
     */
    boolean delete(final Integer idArticleDo);

}
