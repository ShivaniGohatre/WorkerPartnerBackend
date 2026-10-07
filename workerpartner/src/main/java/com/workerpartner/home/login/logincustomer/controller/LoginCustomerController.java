package com.workerpartner.home.login.logincustomer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workerpartner.globalConfig.UsernameTypeDetector;
import com.workerpartner.home.login.logincustomer.service.LoginCustomerService;
import com.workerpartner.home.register.verification.VerificationResponse;

@RestController
@RequestMapping("/api")
public class LoginCustomerController {
	
	
	public LoginCustomerService loginCustService;
	
	LoginCustomerController(LoginCustomerService loginCustService)
	{
		this.loginCustService=loginCustService;
	}
	
	@GetMapping("find/customer")
	public ResponseEntity<VerificationResponse> findCustomer(@RequestParam String username, @RequestParam String password)
	{
		UsernameTypeDetector userNameTypeDetector = new UsernameTypeDetector();
		VerificationResponse response = new VerificationResponse();
		if(userNameTypeDetector.isEmail(username)) {
			response= loginCustService.findEmployeeByEmailAndPassword(username, password);
		}
		else if(userNameTypeDetector.isPhone(username)) {
			response= loginCustService.findEmployeeByPhoneNoAndPassword(username, password);
		}
		
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
}
