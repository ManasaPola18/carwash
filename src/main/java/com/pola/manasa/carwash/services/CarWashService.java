package com.pola.manasa.carwash.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pola.manasa.carwash.daos.CarWashDAO;
import com.pola.manasa.carwash.models.CustCarDetails;
import com.pola.manasa.carwash.models.Customer;
import com.pola.manasa.carwash.models.PromoManagement;
import com.pola.manasa.carwash.models.WashCosts;
import com.pola.manasa.carwash.models.WashPackage;

@Service
public class CarWashService {

	@Autowired
	CarWashDAO carWashDAO;
	
	public String isValidCustomer(String email, String password) {
		return carWashDAO.isValidUser(email, password);
	}
	
	public Customer customerSignUp(Customer customer) {
		return carWashDAO.customerSignUp(customer);
	}
	
	public List<String> getCustomerDetails(String userType){
		return carWashDAO.getCustomerDetails(userType);
	}
	
	public Customer getUserDetails(String emailId) {
		return carWashDAO.getUserDetails(emailId);
	}
	
	public Boolean addCarDetails(CustCarDetails car) {
		return carWashDAO.addCarDetails(car);
	}
	
	public CustCarDetails getCarDetails(Integer id) {
		return carWashDAO.getCarDetails(id);
	}
	
	public List<CustCarDetails> getListOfCars(Integer custId) {
		return carWashDAO.getListOfCars(custId);
	}
	
	public Boolean updateUserDetails(Customer customer) {
		return carWashDAO.updateUserDetails(customer);
	}
	
	public Boolean updateCarDetails(CustCarDetails car) {
		return carWashDAO.updateCarDetails(car);
	}
	
	public List<WashCosts> getListOfWashCosts(String type) {
		return carWashDAO.getListOfWashCosts(type);
	}
	
	public Boolean updateWashCostDetails(WashCosts cost) {
		return carWashDAO.updateWashCostDetails(cost);
	}
	
	public WashCosts getWashCosts(Integer id) {
		return carWashDAO.getWashCosts(id);
	}
	
	public WashCosts getWashCosts(String name, Integer cost, String type) {
		return carWashDAO.getWashCosts(name, cost, type);
	}
	
	public WashCosts saveWashCostDetails(WashCosts cost) {
		return carWashDAO.saveWashCostDetails(cost);
	}
	
	public WashPackage saveWashPackageDetails(WashPackage pack) {
		return carWashDAO.saveWashPackageDetails(pack);
	}
	
	public Boolean updateWashPackageDetails(WashPackage pack) {
		return carWashDAO.updateWashPackageDetails(pack);
	}
	
	public List<WashPackage> getPackages(String packageName) {
		return carWashDAO.getPackages(packageName);
	}
	
	public List<WashCosts> getWashCosts(String id) {
		return carWashDAO.getWashCosts(id);
	}
	
	public List<WashPackage> getPackagesById(Integer id) {
		return carWashDAO.getPackagesById(id);
	}
	
	public List<PromoManagement> getPromoCodes(String promoName){
		return carWashDAO.getPromoCodes(promoName);
	}
	
	public PromoManagement savePromoCodeDetails(PromoManagement promo) {
		return carWashDAO.savePromoCodeDetails(promo);
	}
	
	public Boolean updatePromoCodeDetails(PromoManagement promocode) {
		return carWashDAO.updatePromoCodeDetails(promocode);
	} 
}
