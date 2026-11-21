package com.workerpartner.home.register.registerasemployee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.registerasemployee.service.EmployeeService;
import com.workerpartner.home.register.verification.VerificationResponse;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeService;
	
	
	public EmployeeController(EmployeeService employeService)
	{
		this.employeService= employeService;
	}
	
	@PostMapping("/registeremployee")
	public ResponseEntity<VerificationResponse> createEmployee(@RequestBody EmployeeEntities employeeEntity)
	{
		VerificationResponse response = employeService.createEmployee(employeeEntity);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		
	}
}
