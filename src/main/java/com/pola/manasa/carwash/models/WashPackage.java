package com.pola.manasa.carwash.models;

public class WashPackage {
	
	private Integer id;
	private Integer serviceId;
	private String packageName;
	private String addOnId;
	private Float totalCost;
	private Float discount;
	private Float discountCost;
	private String status;
	
	public WashPackage() {
		super();
	}
		
	public WashPackage(Integer id, Integer serviceId, String packageName, String addOnId, Float totalCost,
			Float discount, Float discountCost, String status) {
		super();
		this.id = id;
		this.serviceId = serviceId;
		this.packageName = packageName;
		this.addOnId = addOnId;
		this.totalCost = totalCost;
		this.discount = discount;
		this.discountCost = discountCost;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getAddOnId() {
		return addOnId;
	}
	public void setAddOnId(String addOnId) {
		this.addOnId = addOnId;
	}
	public Float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Float getDiscountCost() {
		return discountCost;
	}
	public void setDiscountCost(Float discountCost) {
		this.discountCost = discountCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
