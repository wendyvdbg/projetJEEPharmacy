package com.jee.model;

public class Article {
	private int id;
	private String title;
	private int quantity;
	private double price;

	public Article(int id, String title, int quantity, double price) {
		super();
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}
	
	

	public Article() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
