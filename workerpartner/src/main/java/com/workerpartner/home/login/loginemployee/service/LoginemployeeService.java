package com.workerpartner.home.login.loginemployee.service;

import com.workerpartner.home.register.verification.VerificationResponse;

public interface LoginemployeeService {

	public VerificationResponse findEmployeeByEmail(String email, String password);
	public VerificationResponse findEmployeeByPhoneNo(String phoneNo, String password);
	
}
