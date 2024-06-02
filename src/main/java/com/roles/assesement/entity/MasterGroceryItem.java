package com.roles.assesement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="[grocery_item]")
public class MasterGroceryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	protected Integer id;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="price")
	protected Float price;
	
	@Column(name="inventory")
	protected Integer inventory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "MasterGroceryItem [id=" + id + ", name=" + name + ", price=" + price + ", inventory=" + inventory + "]";
	}
	
	
	
	
}
