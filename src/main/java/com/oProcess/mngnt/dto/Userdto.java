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
public class Userdto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@NotNull
	private String userName;
	@NotNull
	private String  userDetails;


	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}

//	public List<Orderdto> getOrderdto() {
//		return orderdto;
//	}
//	public void setOrderdto(List<Orderdto> orderdto) {
//		this.orderdto = orderdto;
//	}
	
	public Userdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Userdto(Long userId, @NotNull String userName, @NotNull String userDetails, List<Orderdto> orderdto) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userDetails = userDetails;
	//	this.orderdto = orderdto;
	}
	

}
