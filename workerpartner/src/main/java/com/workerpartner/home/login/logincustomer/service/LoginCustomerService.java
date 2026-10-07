package com.workerpartner.home.login.logincustomer.service;

import com.workerpartner.home.register.verification.VerificationResponse;

public interface LoginCustomerService {

	public VerificationResponse findEmployeeByEmailAndPassword(String username, String password);
	public VerificationResponse findEmployeeByPhoneNoAndPassword(String username, String password);

}
