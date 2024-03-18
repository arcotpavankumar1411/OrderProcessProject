package com.oProcess.mngnt.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
public class Orderdto {
	@Id
	private long orderId;
	private double totalAmount;
	@NotNull
	private int quantity;

	@OneToMany(targetEntity = Productdto.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "productID")
	List<Productdto> productdto;
	
	
	public List<Productdto> getProductdto() {
		return productdto;
	}
	public void setProductdto(List<Productdto> productdto) {
		this.productdto = productdto;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	public Orderdto(long orderId, double totalAmount, @NotNull int quantity, List<Productdto> productdto,
			List<Userdto> userdto) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
		
	}
	public Orderdto() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
}
