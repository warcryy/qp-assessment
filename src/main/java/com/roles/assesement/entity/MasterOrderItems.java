package com.roles.assesement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="[order_items]")
public class MasterOrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	protected Integer orderId;
	
	@Column(name="user_id")
	protected Integer userId;
	
	@Column(name="item_id")
	protected Integer itemId;
	
	@Column(name="quantity")
	protected Integer quantity;

	@Column(name="time")
	protected String time;
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MasterOrderItems [orderId=" + orderId + ", userId=" + userId + ", itemId=" + itemId + ", quantity="
				+ quantity + ", time=" + time + "]";
	}
	
	
	
}
