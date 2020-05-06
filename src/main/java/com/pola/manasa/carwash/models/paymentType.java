package com.pola.manasa.carwash.models;

import java.util.Date;

public class paymentType {
	
	public Integer id;
	public String payType;
	public String cardNum;
	public Date expiryDate;
	public Integer cvv;
	
	public paymentType() {
		super();
	}
	
	public paymentType(Integer id, String payType, String cardNum, Date expiryDate, Integer cvv) {
		super();
		this.id = id;
		this.payType = payType;
		this.cardNum = cardNum;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "paymentType [id=" + id + ", payType=" + payType + ", cardNum=" + cardNum + ", expiryDate=" + expiryDate
				+ ", cvv=" + cvv + "]";
	}
	
}
