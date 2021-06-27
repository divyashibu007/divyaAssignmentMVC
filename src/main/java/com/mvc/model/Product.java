package com.mvc.model;
import java.util.List;

import javax.persistence.*;
import javax.persistence.ManyToMany;
@Entity
public class Product {
	private int id;
	private String name;
	private float price;

	
	public Product() {
	}

	
	public Product(int id) {
		this.id = id;
	}


	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
