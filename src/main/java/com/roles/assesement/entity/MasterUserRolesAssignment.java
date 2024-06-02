package com.roles.assesement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="[user_roles]")
public class MasterUserRolesAssignment {

	@Id
	@Column(name="user_id")
	protected Integer userId;
	
	@Column(name="role_id")
	protected Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "MasterUserRolesAssignment [userId=" + userId + ", roleId=" + roleId + "]";
	}
	
	
	
}
