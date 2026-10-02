package com.workerpartner.home.register.registerasemployee.serviceimpl;

import org.springframework.stereotype.Service;

import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.registerasemployee.repositories.EmployeeRepo;
import com.workerpartner.home.register.registerasemployee.service.EmployeeService;
import com.workerpartner.sequenceGeneration.constants.SequenceTypes;
import com.workerpartner.sequenceGeneration.services.SequenceGeneratorService;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeRepo employeeRepo;
	public SequenceGeneratorService service;
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo,SequenceGeneratorService service)
	{
		this.employeeRepo= employeeRepo;
		this.service=service;
	}
	
	@Override
	public void createEmployee(EmployeeEntities employeeEntity) {
		String empNo = service.sequenceGeneration(SequenceTypes.EMPLOYEE);
		employeeEntity.setEmpNo(empNo);
		employeeRepo.save(employeeEntity);
	}

	
	
}
