package com.pola.manasa.carwash.models;

public class washPackage {
	
	public Integer id;
	public String packageName;
	public Integer washTypeId;
	public Float cost;
	
	public washPackage() {
		super();
	}

	public washPackage(Integer id, String packageName, Integer washTypeId,  Float cost) {
		super();
		this.id = id;
		this.packageName = packageName;
		this.washTypeId = washTypeId;
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Integer getWashTypeId() {
		return washTypeId;
	}

	public void setWashTypeId(Integer washTypeId) {
		this.washTypeId = washTypeId;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "washPackage [id=" + id + ", packageName=" + packageName + ", washTypeId=" + washTypeId + ", cost="
				+ cost + "]";
	}
	
}
