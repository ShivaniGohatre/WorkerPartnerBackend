package com.workerpartner.home.register.verification.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workerpartner.home.register.verification.VerificationResponse;
import com.workerpartner.home.register.verification.service.VerificationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200") // Fixes "Failed to fetch" CORS error

public class VerificationController {

	private VerificationService verificationService;
	
	public VerificationController(VerificationService verificationService)
	{
		this.verificationService = verificationService;
	}
	
	@GetMapping("/verify/aadhar")
	public ResponseEntity<VerificationResponse> verifyAadhar(@RequestParam String name, @RequestParam String aadharNumber)
	{
		VerificationResponse verificationRespo= verificationService.verifyAadhar(name, aadharNumber);
		 return  ResponseEntity.status(HttpStatus.OK).body(verificationRespo);
		
	}
	@GetMapping("/verify/pan")
	public ResponseEntity<VerificationResponse> verifyPan(@RequestParam String name, @RequestParam String panNumber)
	{
		VerificationResponse verificationRespo = verificationService.verifyPan(name, panNumber);
		
		return ResponseEntity.status(HttpStatus.OK).body(verificationRespo);
		
	}
}
