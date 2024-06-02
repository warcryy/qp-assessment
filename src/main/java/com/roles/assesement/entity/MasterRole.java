package com.roles.assesement.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "[role]")
public class MasterRole {

	@Id
	@Column(name="id")
	protected Integer id;
	
	@Column(name="name")
	protected String name;

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

	@Override
	public String toString() {
		return "MasterRole [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
