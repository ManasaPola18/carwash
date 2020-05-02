package com.pola.manasa.carwash.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
