package com.pola.manasa.carwash.models;

public class Customer {

	public Integer id;
	public String name;
	public String password;
	public String emailId;
	public String phNum;
	public String address;
	public String userType;
		
	public Customer() {
		super();
	}

	public Customer(Integer id, String name, String password, String emailId, String phNum, String address, String userType) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.emailId = emailId;
		this.phNum = phNum;
		this.address = address;
		this.userType = userType;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", emailId=" + emailId + ", phNum="
				+ phNum + ", address=" + address + "]";
	}
}
