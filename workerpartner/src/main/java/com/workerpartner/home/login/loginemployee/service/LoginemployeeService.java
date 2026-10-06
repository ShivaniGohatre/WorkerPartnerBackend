package com.workerpartner.home.login.loginemployee.service;

import com.workerpartner.home.register.verification.VerificationResponse;

public interface LoginemployeeService {

	public VerificationResponse findEmployeeByEmailAndPassword(String email, String password);
	public VerificationResponse findEmployeeByPhoneNoAndPassword(String phoneNo, String password);
	
}
