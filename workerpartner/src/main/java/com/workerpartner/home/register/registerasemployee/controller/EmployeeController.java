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

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeService;
	
	public EmployeeController(EmployeeService employeService)
	{
		this.employeService= employeService;
	}
	
	@PostMapping("/registeremployee")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeEntities employeeEntity)
	{
		employeService.createEmployee(employeeEntity);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
