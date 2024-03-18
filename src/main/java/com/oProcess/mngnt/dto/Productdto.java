package com.oProcess.mngnt.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Productdto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long p_Id;
	@NotNull
	private String productName;
	@NotNull
	private long price;

	public long getP_Id() {
		return p_Id;
	}

	public void setP_Id(long p_Id) {
		this.p_Id = p_Id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Productdto() {

	}

	public Productdto(long p_Id, String productName, long price) {
		super();
		this.p_Id = p_Id;
		this.productName = productName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Productdto [p_Id=" + p_Id + ", productName=" + productName + ", price=" + price + "]";
	}

}
