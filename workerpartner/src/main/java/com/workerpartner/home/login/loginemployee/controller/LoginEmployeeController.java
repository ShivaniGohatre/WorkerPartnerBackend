package com.workerpartner.home.login.loginemployee.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workerpartner.globalConfig.UsernameTypeDetector;
import com.workerpartner.globalConfig.securityConfig.JWTService;
import com.workerpartner.home.login.genericTos.LoginGenericRequest;
import com.workerpartner.home.login.loginemployee.service.LoginemployeeService;
import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.verification.VerificationResponse;


@RestController
@RequestMapping("/api")
public class LoginEmployeeController {
	
	public LoginemployeeService loginEmpService;
	public LoginEmployeeController(LoginemployeeService loginEmpService) {
		this.loginEmpService=loginEmpService;
	}

	@PostMapping("/find/employee")
	public ResponseEntity<VerificationResponse> findEmploye(@RequestBody LoginGenericRequest loginGenericRequest)
	{
		String username = loginGenericRequest.getUsername();
		String password = loginGenericRequest.getPassword();
		
		UsernameTypeDetector userNameTypeDetector = new UsernameTypeDetector();
		
		VerificationResponse response = new VerificationResponse();
		
		if(userNameTypeDetector.isEmail(username)) {
			response= loginEmpService.findEmployeeByEmail(username, password);
		}
		else if(userNameTypeDetector.isPhone(username)) {
			response= loginEmpService.findEmployeeByPhoneNo(username, password);
		}
		
	
		Boolean result = false;
		result= response.isVerified();
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	
	
}
