package com.workerpartner.home.register.registerascustomer.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerascustomer.repository.RegisterAsCustomerRepo;
import com.workerpartner.home.register.registerascustomer.service.RegisterAsCustomerService;
import com.workerpartner.home.register.verification.VerificationResponse;
import com.workerpartner.sequenceGeneration.constants.SequenceTypes;
import com.workerpartner.sequenceGeneration.services.SequenceGeneratorService;

@Service
public class RegisterAsCustomerServiceImpl implements RegisterAsCustomerService {

	
	private final RegisterAsCustomerRepo customRepo;
	public SequenceGeneratorService service;
	public PasswordEncoder passwordEncoder;
	
	public RegisterAsCustomerServiceImpl( RegisterAsCustomerRepo customRepo,
			SequenceGeneratorService service, PasswordEncoder passwordEncoder)
	{
		this.customRepo =  customRepo;
		this.service=service;
		this.passwordEncoder= passwordEncoder;
	}
	
	@Override
	public VerificationResponse registerCustomer(RegisterAsCustomerEntity customerEntity) {

		VerificationResponse verifyRes = new VerificationResponse();
		Optional<RegisterAsCustomerEntity> custPresent = customRepo.searchByEmail(customerEntity.getEmail());
		if (custPresent.isEmpty() || custPresent == null) {
			String custNo = service.sequenceGeneration(SequenceTypes.CUSTOMER);

			customerEntity.setCustNo(custNo);
			
			customerEntity.setPassword(passwordEncoder.encode(customerEntity.getPassword()));
			
			customRepo.save(customerEntity);
			verifyRes.setVerified(true);

		} else {

			verifyRes.setVerified(false);

		}

		return verifyRes;
	}
	
	

}
