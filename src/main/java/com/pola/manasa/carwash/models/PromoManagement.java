package com.pola.manasa.carwash.models;

public class PromoManagement {
	
	private Integer id;
	private String promoName;
	private Integer discountPercentage;
	private Float minimumAmount;
	private Float maximumAmount;
	private String status;
	
	public PromoManagement() {
		super();
	}

	public PromoManagement(Integer id, String promoName, Integer discountPercentage, Float minimumAmount,
			Float maximumAmount, String status) {
		super();
		this.id = id;
		this.promoName = promoName;
		this.discountPercentage = discountPercentage;
		this.minimumAmount = minimumAmount;
		this.maximumAmount = maximumAmount;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	public Integer getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Float getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(Float minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public Float getMaximumAmount() {
		return maximumAmount;
	}

	public void setMaximumAmount(Float maximumAmount) {
		this.maximumAmount = maximumAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PromoManagement [id=" + id + ", promoName=" + promoName + ", discountPercentage=" + discountPercentage
				+ ", minimumAmount=" + minimumAmount + ", maximumAmount=" + maximumAmount + ", status=" + status + "]";
	}
	
	
}
