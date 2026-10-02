package com.workerpartner.home.register.registerascustomer.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerascustomer.repository.RegisterAsCustomerRepo;
import com.workerpartner.home.register.registerascustomer.service.RegisterAsCustomerService;
import com.workerpartner.sequenceGeneration.constants.SequenceTypes;
import com.workerpartner.sequenceGeneration.services.SequenceGeneratorService;

@Service
public class RegisterAsCustomerServiceImpl implements RegisterAsCustomerService {

	
	private final RegisterAsCustomerRepo customRepo;
	public SequenceGeneratorService service;
	
	public RegisterAsCustomerServiceImpl( RegisterAsCustomerRepo customRepo,
			SequenceGeneratorService service)
	{
		this.customRepo =  customRepo;
		this.service=service;
	}
	
	@Override
	public void registerCustomer(RegisterAsCustomerEntity customerEntity) {
		String custNo = service.sequenceGeneration(SequenceTypes.CUSTOMER);
		customerEntity.setCustNo(custNo);
		customRepo.save(customerEntity);
	}
	
	

}
