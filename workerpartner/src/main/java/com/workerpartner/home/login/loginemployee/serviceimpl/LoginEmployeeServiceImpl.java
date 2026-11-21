package com.workerpartner.home.login.loginemployee.serviceimpl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workerpartner.globalConfig.securityConfig.JWTService;
import com.workerpartner.home.login.loginemployee.repository.LoginEmployeeRepository;
import com.workerpartner.home.login.loginemployee.service.LoginemployeeService;
import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.verification.VerificationResponse;

@Service
public class LoginEmployeeServiceImpl implements LoginemployeeService {
	private LoginEmployeeRepository loginEmployeeRepository;
	public JWTService jwtService;
	public PasswordEncoder passwordEncoder;



	public LoginEmployeeServiceImpl(LoginEmployeeRepository loginEmployeeRepository, JWTService jwtService, PasswordEncoder passwordEncoder) {
		this.loginEmployeeRepository = loginEmployeeRepository;
		this.jwtService = jwtService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public VerificationResponse findEmployeeByEmail(String email, String password) {
		Optional<EmployeeEntities> employeeObj = loginEmployeeRepository.searchByEmail(email).filter(c -> passwordEncoder.matches(password, c.getPassword()));
		/*
		 * .orElseThrow(() -> new IllegalArgumentException("Email or password is empty"
		 * + email + " " + password))
		 */
		

		return buildResponse(employeeObj);
	}

	public VerificationResponse buildResponse(Optional<EmployeeEntities> employeeEntityMatch)
	{
		VerificationResponse verifyResponse = new VerificationResponse();
		
		if(employeeEntityMatch.isPresent())
		{
			EmployeeEntities employeeEntities = employeeEntityMatch.get();
			
			verifyResponse.setVerified(true);
			verifyResponse.setName(employeeEntities.getFirstName()+""+employeeEntities.getLastName());
			verifyResponse.setToken(jwtService.generateToken(employeeEntities.getId(), "EMPLOYEE"));
			verifyResponse.setMessage("Login Successful");
		}
		 else {
	        	
	        	verifyResponse.setVerified(false);
	        	verifyResponse.setMessage("Invalid Email/Phone Number");

	        }
		
        return verifyResponse;


	}
	@Override
	public VerificationResponse findEmployeeByPhoneNo(String phoneNo, String password) {
		Optional<EmployeeEntities> employeeObj = loginEmployeeRepository.searchByPhoneNo(phoneNo).filter(c -> passwordEncoder.matches(password, c.getPassword()));
		return buildResponse(employeeObj);

	}

}
