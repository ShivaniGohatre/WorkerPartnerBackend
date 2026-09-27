package com.workerpartner.home.register.verification.service;

import com.workerpartner.home.register.verification.VerificationResponse;

public interface VerificationService {

	public VerificationResponse verifyAadhar(String name, String aadhar);
	
}
