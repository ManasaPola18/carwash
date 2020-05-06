package com.pola.manasa.carwash.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pola.manasa.carwash.models.CustCarDetails;
import com.pola.manasa.carwash.models.Customer;
import com.pola.manasa.carwash.services.CarWashService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/carwash")
@RestController
public class CarWashController {
	
	Logger logger = LoggerFactory.getLogger(CarWashController.class);
	
	@Autowired
	CarWashService carWashService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String login(@RequestParam String email, @RequestParam String password) {
		logger.info("In login method");
		return carWashService.isValidCustomer(email, password);
	} 
	
	@RequestMapping(method = RequestMethod.POST, path="/saveCustomer")
	public Boolean customerSignUp(@RequestBody Customer customer) {
		logger.info("in customer sign up method");
		return carWashService.customerSignUp(customer);
	}
	
	@RequestMapping(method= RequestMethod.GET, path = "/userList")
	public List<String> userList(@RequestParam String userType){
		logger.info("In user list method");
		return carWashService.getCustomerDetails(userType);
	}	
	
	@RequestMapping(method= RequestMethod.GET, path = "/userdetails")
	public Customer getUserDetails(@RequestParam String emailId) {
		return carWashService.getUserDetails(emailId);
	}
	
	@RequestMapping(method= RequestMethod.POST, path = "/addcar")
	public Boolean addCarDetails(@RequestBody CustCarDetails car) {
		return carWashService.addCarDetails(car);
	}
	
	@RequestMapping(method= RequestMethod.GET, path = "/cardetails")
	public CustCarDetails getCarDetails(@RequestParam Integer id) {
		return carWashService.getCarDetails(id);
	}
	
	@RequestMapping(method= RequestMethod.GET, path = "/cars")
	public List<CustCarDetails> getListOfCars(@RequestParam Integer custId) {
		return carWashService.getListOfCars(custId);
	}
	
	@RequestMapping(method= RequestMethod.POST, path="/userdetails")
	public Boolean updateUserDetails(@RequestBody Customer customer) {
		return carWashService.updateUserDetails(customer);
	}
}
