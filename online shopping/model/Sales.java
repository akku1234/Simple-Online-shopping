package com.llts.miniproject.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sales")
public class Sales {
	
	@Id
	private int salesid;
	private LocalDate salesdate;
	private int quantity;
	private int totalcost;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "email")
	private User user;
	
	public Sales() {
		super();
	}

	public Sales(int salesid, LocalDate salesdate, int quantity, int totalcost, Product product,
			User user) {
		super();
		this.salesid = salesid;
		this.salesdate = salesdate;
		this.quantity = quantity;
		this.totalcost = totalcost;
		this.product = product;
		this.user = user;
	}

	public int getSalesid() {
		return salesid;
	}

	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}
	public LocalDate getSalesdate() {
		return salesdate;
	}

	public void setSalesdate(LocalDate salesdate) {
		this.salesdate = salesdate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Sales [salesid=" + salesid + ", salesdate=" + salesdate + ", quantity="
				+ quantity + ", totalcost=" + totalcost + ", product=" + product + ", user=" + user + "]";
	}

}
