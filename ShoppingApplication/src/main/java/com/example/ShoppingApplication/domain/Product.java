package com.example.ShoppingApplication.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Random;

@Entity
public class Product {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String productname;
	private String picture_url="";
	private double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id, String productname, String picture_url, double price) {
		super();
		this.id = id;
		this.productname = productname;
		this.picture_url = picture_url;
		this.price = price;
	}
	
	public Product( String productname, double price) {
		super();
		this.productname = productname;
//		this.picture_url = picture_url;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
