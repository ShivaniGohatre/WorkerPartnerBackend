package com.workerpartner.home.login.logincustomer.serviceimpl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workerpartner.globalConfig.securityConfig.JWTService;
import com.workerpartner.home.login.logincustomer.repository.LoginCustomerRepository;
import com.workerpartner.home.login.logincustomer.service.LoginCustomerService;
import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.verification.VerificationResponse;

@Service
public class LoginCustomerServiceImpl implements LoginCustomerService{

	
	public LoginCustomerRepository loginCustomerRepo;
	public PasswordEncoder passwordEncoder;
	public JWTService jwtService;
	
	public LoginCustomerServiceImpl(LoginCustomerRepository loginCustomerRepo, PasswordEncoder passwordEncoder, JWTService jwtService)
	{
		this.loginCustomerRepo=loginCustomerRepo;
		this.passwordEncoder= passwordEncoder;
		this.jwtService= jwtService;
	}
	@Override
	public VerificationResponse findCustomerByEmailAndPassword(String email, String password) {
		Optional<RegisterAsCustomerEntity> employeeObj = loginCustomerRepo.searchByEmail(email).filter(c -> passwordEncoder.matches(password, c.getPassword()));
		/*
		 * .orElseThrow(() -> new IllegalArgumentException("Email or password is empty"
		 * + email + " " + password))
		 */
		
		return buildResponse(employeeObj);
	}
	
	
	public VerificationResponse buildResponse(Optional<RegisterAsCustomerEntity> customerEntityMatch )
	{
		VerificationResponse verifyResponse = new VerificationResponse();
		
        if(customerEntityMatch.isPresent()) {
        	
        	RegisterAsCustomerEntity customerEntity = customerEntityMatch.get();
        	
        	verifyResponse.setVerified(true);
        	verifyResponse.setToken(jwtService.generateToken(customerEntity.getId(), "CUSTOMER"));
        	verifyResponse.setName(customerEntity.getFirstName()+""+customerEntity.getLastName());
        	verifyResponse.setMessage("Login Successful");
        }
        else {
        	
        	verifyResponse.setVerified(false);
        	verifyResponse.setMessage("Invalid Email/Phone Number");

        }
        
        return verifyResponse;
	}
	
	

	@Override
	public VerificationResponse findCustomerByPhoneNoAndPassword(String phoneNo, String password) {
		Optional<RegisterAsCustomerEntity> employeeObj = loginCustomerRepo.searchByPhoneNo(phoneNo).filter(c -> passwordEncoder.matches(password, c.getPassword()));
		VerificationResponse verifyResponse = new VerificationResponse();
		if (employeeObj != null) {
			verifyResponse.setVerified(true);
		} else {
			verifyResponse.setVerified(false);
		}

		return verifyResponse;
	}




}
