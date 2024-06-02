package com.roles.assesement.entity;



import jakarta.persistence.*;


@Entity
@Table(name = "[user]")
public class MasterUser {

	@Id
	@Column(name="id")
	protected Integer id;
	
	@Column(name="username")
	protected String userName;
	
	@Column(name="password")
	protected String password;
	
	@Column(name="email")
	protected String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MasterUser [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}
	
	
	
}
