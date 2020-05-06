package com.pola.manasa.carwash.models;

import java.util.Date;

public class washOrderRequest {
	
	public Integer id;
	public Integer custId;
	public Integer carId;
	public String workStatus;
	public Integer washTypeId;
	public Integer washPackageId;
	public Date date;
	public Date completionDate;
	public String washLocation;
	
	public washOrderRequest() {
		super();
	}
	
	public washOrderRequest(Integer id, Integer custId, Integer carId, String workStatus, Integer washTypeId, Integer washPackageId,
			Date date, Date completionDate, String washLocation) {
		super();
		this.id = id;
		this.custId = custId;
		this.carId = carId;
		this.workStatus = workStatus;
		this.washTypeId = washTypeId;
		this.washPackageId = washPackageId;
		this.date = date;
		this.completionDate = completionDate;
		this.washLocation = washLocation;
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

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public Integer getWashTypeId() {
		return washTypeId;
	}

	public void setWashTypeId(Integer washTypeId) {
		this.washTypeId = washTypeId;
	}

	public Integer getWashPackageId() {
		return washPackageId;
	}

	public void setWashPackageId(Integer washPackageId) {
		this.washPackageId = washPackageId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getWashLocation() {
		return washLocation;
	}

	public void setWashLocation(String washLocation) {
		this.washLocation = washLocation;
	}

	@Override
	public String toString() {
		return "washOrderRequest [id=" + id + ", custId=" + custId + ", carId=" + carId + ", workStatus=" + workStatus
				+ ", washTypeId=" + washTypeId + ", washPackageId=" + washPackageId + ", date=" + date
				+ ", completionDate=" + completionDate + ", washLocation=" + washLocation + "]";
	}
	
}
