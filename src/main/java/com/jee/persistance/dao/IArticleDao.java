package com.jee.persistance.dao;

import java.util.List;

import com.jee.persistance.beanDo.ArticleDo;

public interface IArticleDao {
	
	/**
	 * Permet de creer un articleDo
	 * 
	 * @param articleDo
	 * @return articleDo
	 */
	ArticleDo create(final ArticleDo articleDo);
	
	/**
     * Permet de rechercher un produit selon son Id
     * 
     * @param idArticleDo  l'id du produit � rechercher
     * @return le produit recherch�, null sinon
     */
	ArticleDo find(final Integer idArticleDo );

    /**
     * Permet de retrouver tous les produits
     * 
     * @return la liste de tous les produits, vide ou remplie
     */
    List<ArticleDo> findAll ();

    /**
     * Permet de mettre � jour un produit
     * 
     * @param idArticleDo  l'id du produit � mettre � jour
     * @param articleDo  le produit
     * @return le produit mis � jour, null en cas de probl�me
     */
    ArticleDo update(final Integer idArticleDo, final ArticleDo articleDo);

    /**
     * Permet de supprimer un produit selon son id
     * 
     * @param idArticleDo  l'id du produit � supprimer
     * @return true si OK, false sinon
     */
    boolean delete(final Integer idProduitDo);

}
