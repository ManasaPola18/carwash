package com.pola.manasa.carwash.models;

public class paymentDetails {
	
	public Integer id;
	public Integer washOrderRequestId;
	public String status;
	public Integer amount;
	public Integer paymentTypeId;
	
	public paymentDetails() {
		super();
	}
	
	public paymentDetails(Integer id, Integer washOrderRequestId, String status, Integer amount, Integer paymentTypeId ) {
		super();
		this.id = id;
		this.washOrderRequestId = washOrderRequestId;
		this.status = status;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWashOrderRequestId() {
		return washOrderRequestId;
	}

	public void setWashOrderRequestId(Integer washOrderRequestId) {
		this.washOrderRequestId = washOrderRequestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	@Override
	public String toString() {
		return "paymentDetails [id=" + id + ", washOrderRequestId=" + washOrderRequestId + ", status=" + status
				+ ", amount=" + amount + ", paymentTypeId=" + paymentTypeId + "]";
	}
	
}
