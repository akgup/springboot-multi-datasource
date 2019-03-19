package com.buzzybrains.entity.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * akshay gupta
 * 
 * 19-Mar-2019
 * 
 **/

@Entity
@Table(schema = "product", name = "product_jpa")
public class Product {

	@Id
	private int id;

	private String name;

	private double price;



	public Product() {
		super();
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
