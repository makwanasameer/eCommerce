package com.example.demo;

import java.util.List;

public class AdminSummary {
    private int itemCount;
    private double totalPurchaseAmount;
    private List<DiscountCode> discountCodes;
    private double totalDiscountAmount;
	
    public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public double getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}
	public void setTotalPurchaseAmount(double totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	public List<DiscountCode> getDiscountCodes() {
		return discountCodes;
	}
	public void setDiscountCodes(List<DiscountCode> discountCodes) {
		this.discountCodes = discountCodes;
	}
	public double getTotalDiscountAmount() {
		return totalDiscountAmount;
	}
	public void setTotalDiscountAmount(double totalDiscountAmount) {
		this.totalDiscountAmount = totalDiscountAmount;
	}

    // Getters and setters
}
