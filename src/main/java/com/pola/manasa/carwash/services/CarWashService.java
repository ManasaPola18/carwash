package com.pola.manasa.carwash.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pola.manasa.carwash.daos.CarWashDAO;
import com.pola.manasa.carwash.models.Customer;

@Service
public class CarWashService {

	@Autowired
	CarWashDAO carWashDAO;
	
	public String isValidCustomer(String email, String password) {
		return carWashDAO.isValidUser(email, password);
	}
	
	public Boolean customerSignUp(Customer customer) {
		return carWashDAO.customerSignUp(customer);
	}
	
	public List<String> getCustomerDetails(String userType){
		return carWashDAO.getCustomerDetails(userType);
	}
}
