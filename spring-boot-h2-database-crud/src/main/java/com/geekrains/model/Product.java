package com.geekrains.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "cost")
	private Double cost;

	public Product() {
	}

	public Product(int id, String title, Double cost) {
		this.id = id;
		this.title = title;
		this.cost = cost;
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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", title='" + title + '\'' +
				", cost=" + cost +
				'}';
	}

}
