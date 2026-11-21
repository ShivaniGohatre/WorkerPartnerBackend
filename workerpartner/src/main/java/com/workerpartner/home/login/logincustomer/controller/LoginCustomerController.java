package com.workerpartner.home.login.logincustomer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workerpartner.globalConfig.UsernameTypeDetector;
import com.workerpartner.home.login.genericTos.LoginGenericRequest;
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
	
	@PostMapping("find/customer")
	public ResponseEntity<VerificationResponse> findCustomer(@RequestBody LoginGenericRequest loginGenericRequest)
	{
		
		String username= loginGenericRequest.getUsername();
		String password = loginGenericRequest.getPassword();
		
		UsernameTypeDetector userNameTypeDetector = new UsernameTypeDetector();
		VerificationResponse response = new VerificationResponse();
		if(userNameTypeDetector.isEmail(username)) {
			response= loginCustService.findCustomerByEmailAndPassword(username, password);
		}
		else if(userNameTypeDetector.isPhone(username)) {
			response= loginCustService.findCustomerByPhoneNoAndPassword(username, password);
		}
		
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
}
