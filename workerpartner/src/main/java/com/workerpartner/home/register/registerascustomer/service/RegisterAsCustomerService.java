package com.workerpartner.home.register.registerascustomer.service;

import org.springframework.stereotype.Component;

import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.verification.VerificationResponse;

public interface RegisterAsCustomerService {

	public VerificationResponse registerCustomer(RegisterAsCustomerEntity customerEntity);
	
}
