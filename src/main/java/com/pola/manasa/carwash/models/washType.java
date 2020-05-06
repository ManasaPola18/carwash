package com.pola.manasa.carwash.models;

public class washType {
	
	public Integer id;
	public String type;
	public Float cost;
	
	public washType() {
		super();
	}
	
	public washType(Integer id, String type, Float cost) {
		super();
		this.id = id;
		this.type = type;
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "washType [id=" + id + ", type=" + type + ", cost=" + cost + "]";
	}
	
}
