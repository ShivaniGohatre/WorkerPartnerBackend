package com.workerpartner.home.login.loginemployee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workerpartner.home.register.verification.VerificationResponse;

@RestController
@RequestMapping("/api")
public class LoginEmployeeController {
	

	@GetMapping("/find/employee")
	public ResponseEntity<VerificationResponse> findEmploye(@RequestParam String email, @RequestParam String mobilenumber, @RequestParam String password)
	{
	 return null;	
	}

}
