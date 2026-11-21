package com.workerpartner.home.register.registerasemployee.service;

import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.verification.VerificationResponse;

public interface EmployeeService {

	public VerificationResponse createEmployee(EmployeeEntities employeeEntity);
}
