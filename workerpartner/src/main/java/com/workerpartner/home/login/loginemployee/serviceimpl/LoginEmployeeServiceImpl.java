package com.workerpartner.home.login.loginemployee.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.workerpartner.home.login.loginemployee.repository.LoginEmployeeRepository;
import com.workerpartner.home.login.loginemployee.service.LoginemployeeService;
import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.verification.VerificationResponse;

@Service
public class LoginEmployeeServiceImpl implements LoginemployeeService {
	private LoginEmployeeRepository loginEmployeeRepository;

	public LoginEmployeeServiceImpl(LoginEmployeeRepository loginEmployeeRepository) {
		this.loginEmployeeRepository = loginEmployeeRepository;
	}

	@Override
	public VerificationResponse findEmployeeByEmailAndPassword(String email, String password) {
		Optional<EmployeeEntities> employeeObj = loginEmployeeRepository.searchByEmailAndPassword(email, password);
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
		Optional<EmployeeEntities> employeeObj = loginEmployeeRepository.searchByPhoneNoAndPassword(phoneNo, password);
		VerificationResponse verifyResponse = new VerificationResponse();
		if (employeeObj != null) {
			verifyResponse.setVerified(true);
		} else {
			verifyResponse.setVerified(false);
		}

		return verifyResponse;
	}

}
