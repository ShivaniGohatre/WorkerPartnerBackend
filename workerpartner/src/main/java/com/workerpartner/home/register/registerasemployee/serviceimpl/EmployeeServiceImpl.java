package com.workerpartner.home.register.registerasemployee.serviceimpl;

import org.springframework.stereotype.Service;

import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.registerasemployee.repositories.EmployeeRepo;
import com.workerpartner.home.register.registerasemployee.service.EmployeeService;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeRepo employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo)
	{
		this.employeeRepo= employeeRepo;
	}
	
	@Override
	public void createEmployee(EmployeeEntities employeeEntity) {
		
		employeeRepo.save(employeeEntity);
	}

	
	
}
