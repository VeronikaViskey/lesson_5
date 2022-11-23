package com.geekrains.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
	@ManyToMany
	@JoinTable(
			name = "customers_products",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "customer_id")
	)
	private Set<Customer> productCustomers;


	public Product() {
	}

	public Product(int id, String title, Double cost) {
		this.id = id;
		this.title = title;
		this.cost = cost;
		this.productCustomers = Collections.<Customer>emptySet();  ;
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

	public Set<Customer> getProductCustomers() {
		return productCustomers;
	}

	public void setProductCustomers(Set<Customer> productCustomers) {
		this.productCustomers = productCustomers;
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
