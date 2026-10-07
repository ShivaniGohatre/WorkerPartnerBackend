package com.workerpartner.home.register.registerascustomer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerascustomer.service.RegisterAsCustomerService;
import com.workerpartner.home.register.verification.VerificationResponse;

@RestController
@RequestMapping("/api")
public class RegisterAsCustomerController {

	private final RegisterAsCustomerService customerService;
	
	public RegisterAsCustomerController(RegisterAsCustomerService customerService)
	{
		this.customerService = customerService;
	}
	
	@PostMapping("/registercustomer")
	public ResponseEntity<VerificationResponse> registerCustomer(@RequestBody RegisterAsCustomerEntity customerEntity)
	{
		
		VerificationResponse response = customerService.registerCustomer(customerEntity);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
}
