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
     * @param idArticleDo  l'id du produit à rechercher
     * @return le produit recherché, null sinon
     */
	ArticleDo find(final Integer idArticleDo );

    /**
     * Permet de retrouver tous les produits
     * 
     * @return la liste de tous les produits, vide ou remplie
     */
    List<ArticleDo> findAll ();

    /**
     * Permet de mettre à jour un produit
     * 
     * @param idArticleDo  l'id du produit à mettre à jour
     * @param articleDo  le produit
     * @return le produit mis à jour, null en cas de problème
     */
    ArticleDo update(final Integer idArticleDo, final ArticleDo articleDo);

    /**
     * Permet de supprimer un produit selon son id
     * 
     * @param idArticleDo  l'id du produit à supprimer
     * @return true si OK, false sinon
     */
    boolean delete(final Integer idProduitDo);

}
