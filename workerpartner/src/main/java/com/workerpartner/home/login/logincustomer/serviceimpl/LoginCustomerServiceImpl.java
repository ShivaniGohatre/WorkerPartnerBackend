package com.workerpartner.home.login.logincustomer.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.workerpartner.home.login.logincustomer.repository.LoginCustomerRepository;
import com.workerpartner.home.login.logincustomer.service.LoginCustomerService;
import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.verification.VerificationResponse;

@Service
public class LoginCustomerServiceImpl implements LoginCustomerService{

	
	public LoginCustomerRepository loginCustomerRepo;
	
	public LoginCustomerServiceImpl(LoginCustomerRepository loginCustomerRepo)
	{
		this.loginCustomerRepo=loginCustomerRepo;
	}
	@Override
	public VerificationResponse findEmployeeByEmailAndPassword(String email, String password) {
		Optional<RegisterAsCustomerEntity> employeeObj = loginCustomerRepo.searchByEmailAndPassword(email, password);
		/*
		 * .orElseThrow(() -> new IllegalArgumentException("Email or password is empty"
		 * + email + " " + password))
		 */
		VerificationResponse verifyResponse = new VerificationResponse();
		if (employeeObj != null) {
			verifyResponse.setVerified(true);
		} else {
			verifyResponse.setVerified(false);
		}

		return verifyResponse;
	}

	@Override
	public VerificationResponse findEmployeeByPhoneNoAndPassword(String phoneNo, String password) {
		Optional<RegisterAsCustomerEntity> employeeObj = loginCustomerRepo.searchByPhoneNoAndPassword(phoneNo, password);
		VerificationResponse verifyResponse = new VerificationResponse();
		if (employeeObj != null) {
			verifyResponse.setVerified(true);
		} else {
			verifyResponse.setVerified(false);
		}

		return verifyResponse;
	}




}
