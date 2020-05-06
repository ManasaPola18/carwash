package com.pola.manasa.carwash.models;

//import java.util.Date;

public class addOnRequest {
	
	public Integer id;
	public Integer washOrderId;
	public Integer addOnId;
	
	public addOnRequest() {
		super();	
	}
	
	public addOnRequest(Integer id, Integer washOrderId, Integer addOnId) {
		super();
		this.id = id;
		this.washOrderId = washOrderId;
		this.addOnId = addOnId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWashOrderId() {
		return washOrderId;
	}

	public void setWashOrderId(Integer washOrderId) {
		this.washOrderId = washOrderId;
	}

	public Integer getAddOnId() {
		return addOnId;
	}

	public void setAddOnId(Integer addOnId) {
		this.addOnId = addOnId;
	}

	@Override
	public String toString() {
		return "addOnRequest [id=" + id + ", washOrderId=" + washOrderId + ", addOnId=" + addOnId + "]";
	}
	
}

