package com.pola.manasa.carwash.models;

import java.util.Date;

public class Orders {
	
	public Integer id;
	public Integer custID;
	public Integer carID;
	public String workStatus;
	public Integer washTypeID;
	public Integer washPackageID;
	public Date orderDate;
	public Date completionDate;
	public String workLocation;
	
	public Orders() {
		super();
	}
	
	public Orders(Integer id, Integer custID, Integer carID, String workStatus, Integer washTypeID, Integer washPackageID,
	Date orderDate, Date completionDate, String workLocation) {
		super();
		this.id = id;
		this.custID = custID;
		this.carID = carID;
		this.workStatus = workStatus;
		this.washTypeID = washTypeID;
		this.washPackageID = washPackageID;
		this.orderDate = orderDate;
		this.completionDate = completionDate;
		this.workLocation = workLocation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustID() {
		return custID;
	}

	public void setCustID(Integer custID) {
		this.custID = custID;
	}

	public Integer getCarID() {
		return carID;
	}

	public void setCarID(Integer carID) {
		this.carID = carID;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public Integer getWashTypeID() {
		return washTypeID;
	}

	public void setWashTypeID(Integer washTypeID) {
		this.washTypeID = washTypeID;
	}

	public Integer getWashPackageID() {
		return washPackageID;
	}

	public void setWashPackageID(Integer washPackageID) {
		this.washPackageID = washPackageID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", custID=" + custID + ", carID=" + carID + ", workStatus=" + workStatus
				+ ", washTypeID=" + washTypeID + ", washPackageID=" + washPackageID + ", orderDate=" + orderDate
				+ ", completionDate=" + completionDate + ", workLocation=" + workLocation + "]";
	}
	
	
}
