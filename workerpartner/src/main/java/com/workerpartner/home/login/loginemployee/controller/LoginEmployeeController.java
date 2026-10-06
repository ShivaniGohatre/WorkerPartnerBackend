package com.workerpartner.home.login.loginemployee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workerpartner.globalConfig.UsernameTypeDetector;
import com.workerpartner.home.login.loginemployee.service.LoginemployeeService;
import com.workerpartner.home.register.verification.VerificationResponse;


@RestController
@RequestMapping("/api")
public class LoginEmployeeController {
	
	public LoginemployeeService loginEmpService;
	public LoginEmployeeController(LoginemployeeService loginEmpService) {
		this.loginEmpService=loginEmpService;
	}

	@GetMapping("/find/employee")
	public ResponseEntity<Boolean> findEmploye(@RequestParam String username, @RequestParam String password)
	{
		UsernameTypeDetector userNameTypeDetector = new UsernameTypeDetector();
		VerificationResponse response = new VerificationResponse();
		if(userNameTypeDetector.isEmail(username)) {
			response= loginEmpService.findEmployeeByEmailAndPassword(username, password);
		}
		else if(userNameTypeDetector.isPhone(username)) {
			response= loginEmpService.findEmployeeByPhoneNoAndPassword(username, password);
		}
		
	
		Boolean result = false;
		result= response.isVerified();
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}

}
