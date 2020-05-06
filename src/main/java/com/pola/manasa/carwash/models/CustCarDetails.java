package com.pola.manasa.carwash.models;

public class CustCarDetails {
	
	public Integer id;
	public Integer custId;
	public String carNum;
	public String carType;
	public String carColor;
	public String regNum;
	public String carStatus;
	
	public CustCarDetails() {
		super();
	}
	
	public CustCarDetails(Integer id, Integer custId, String carNum, String carType, String carColor, String regNum, String carStatus) {
		super();
		this.id = id;
		this.custId = custId;
		this.carNum = carNum;
		this.carType = carType;
		this.carColor = carColor;
		this.regNum = regNum;
		this.carStatus = carStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}

	@Override
	public String toString() {
		return "custCarDetails [id=" + id + ", custId=" + custId + ", carNum=" + carNum + ", carType=" + carType
				+ ", carColor=" + carColor + ", regNum=" + regNum + ", carStatus=" + carStatus + "]";
	}
	
}
