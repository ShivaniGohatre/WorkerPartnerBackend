package com.workerpartner.home.login.logincustomer.service;

import com.workerpartner.home.register.verification.VerificationResponse;

public interface LoginCustomerService {

	public VerificationResponse findCustomerByEmailAndPassword(String username, String password);
	public VerificationResponse findCustomerByPhoneNoAndPassword(String username, String password);

}
