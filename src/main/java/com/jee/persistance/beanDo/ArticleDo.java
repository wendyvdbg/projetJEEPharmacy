package com.jee.persistance.beanDo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * @author Wendy
 *
 */
@Entity(name = "ArticleDo")
@Table(name = "articles")
@NamedQuery(name = "allUArticle", query = "From ArticleDo")


public class ArticleDo implements Serializable{
	 /**
     * 
     */
	 private static final long serialVersionUID = -965089722446416562L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer               id;
    @Column(name = "title")
    private String            title;
    @Column(name = "quantity")
    private String           quantity;
    @Column(name = "price")
    private Integer price;
    
    /**
     * Constructeur par défaut
     */
	public ArticleDo() {
		super();
	}

	 /**
     * @return the id
     */
	public Integer getId() {
		return id;
	}

	   /**
     * @param id the id to set
     */
	public void setId(final Integer id) {
		this.id = id;
	}

	  /**
     * @return the title
     */
	public String getTitle() {
		return title;
	}

	 /**
     * @param title the title to set
     */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
     * @return the quantity
     */
	public String getQuantity() {
		return quantity;
	}

	 /**
     * @param quantity the quantity to set
     */
	public void setQuantity(final String quantity) {
		this.quantity = quantity;
	}

	/**
     * @return the price
     */
	public Integer getPrice() {
		return price;
	}

	  /**
     * @param price the price to set
     */
	public void setPrice(final Integer price) {
		this.price = price;
	}
	
	
    
    

	
    
	
}
