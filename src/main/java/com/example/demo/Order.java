package com.example.demo;

import java.util.List;

public class Order {
    private String orderId;
    private List<CartItem> items;
    private double totalAmount;
    private boolean discountApplied;
    private double discountAmount;
	
    public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public boolean isDiscountApplied() {
		return discountApplied;
	}
	public void setDiscountApplied(boolean discountApplied) {
		this.discountApplied = discountApplied;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

    // Getters and setters
}
