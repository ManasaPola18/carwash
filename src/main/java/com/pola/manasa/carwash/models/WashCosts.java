package com.pola.manasa.carwash.models;

public class WashCosts {

	private Integer id;
	private String name;
	private Integer cost;
	private String type;
		
	public WashCosts() {
		super();
	}
	
	public WashCosts(Integer id, String name, Integer cost, String type) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.type = type;
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
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
