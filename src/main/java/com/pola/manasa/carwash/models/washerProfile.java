package com.pola.manasa.carwash.models;

public class washerProfile {
	
	public Integer id;
	public String name;
	public String address;
	public String phNum;
	public Integer experience;
	
	public washerProfile() {
		super();
	}
	
	public washerProfile(Integer id, String name, String address, String phNum, Integer experience) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phNum = phNum;
		this.experience = experience;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhNum() {
		return phNum;
	}

	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "washerProfile [id=" + id + ", name=" + name + ", address=" + address + ", phNum=" + phNum
				+ ", experience=" + experience + "]";
	}
	
}
