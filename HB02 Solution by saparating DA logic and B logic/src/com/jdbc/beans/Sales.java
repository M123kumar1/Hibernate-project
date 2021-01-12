package com.jdbc.beans;

import java.util.Date;

public class Sales {
	private String customerName;
	private Date date;
	private int qty;
	private int discount;// Sales Entity

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	private double totalAmount;
	private double paidAmount;

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Date getDate() {
		return date;
	}

	public int getQty() {
		return qty;
	}

	public int getDiscount() {
		return discount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	@Override
	public String toString() {
		return "Sales [customerName=" + customerName + ", date=" + date + ", qty=" + qty + ", discount=" + discount
				+ ", paidAmount=" + paidAmount + "]";
	}
}
