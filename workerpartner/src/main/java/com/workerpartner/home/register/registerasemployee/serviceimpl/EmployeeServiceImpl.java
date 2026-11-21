package com.workerpartner.home.register.registerasemployee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.registerasemployee.entities.EmployeeSkill;
import com.workerpartner.home.register.registerasemployee.repositories.EmployeeRepo;
import com.workerpartner.home.register.registerasemployee.repositories.EmployeeSkillRepo;
import com.workerpartner.home.register.registerasemployee.service.EmployeeService;
import com.workerpartner.home.register.verification.VerificationResponse;
import com.workerpartner.sequenceGeneration.constants.SequenceTypes;
import com.workerpartner.sequenceGeneration.services.SequenceGeneratorService;
import com.workerpartner.servicecategory.entity.ServiceCategory;
import com.workerpartner.servicecategory.repository.ServiceCategoryRepository;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeRepo employeeRepo;
	public SequenceGeneratorService service;
	public ServiceCategoryRepository serviceRepo;
	public EmployeeSkillRepo employeeSkillRepo;
	public PasswordEncoder passwordEncoder;

	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo,SequenceGeneratorService service,  EmployeeSkillRepo employeeSkillRepo, ServiceCategoryRepository serviceRepo,  PasswordEncoder passwordEncoder)
	{
		this.employeeRepo= employeeRepo;
		this.service=service;
		this.employeeSkillRepo=employeeSkillRepo;
		this.serviceRepo = serviceRepo;
		this.passwordEncoder=passwordEncoder;
	}
	
	@Override
	public VerificationResponse createEmployee(EmployeeEntities employeeEntity) {
		
		VerificationResponse veriResp = new VerificationResponse();
		ServiceCategory serviceCat = new ServiceCategory();
		
		Optional<EmployeeEntities> employeeMail = employeeRepo.searchByEmail(employeeEntity.getEmail());
		
		if(employeeMail.isEmpty() || employeeMail == null)
		{
			String empNo = service.sequenceGeneration(SequenceTypes.EMPLOYEE);
			employeeEntity.setEmpNo(empNo);
			employeeEntity.setPassword(passwordEncoder.encode(employeeEntity.getPassword()));
			
			
			EmployeeEntities savedEmployeeEntity = employeeRepo.save(employeeEntity);
			
			for(String profession: employeeEntity.getProfessionList())
			{
				EmployeeSkill employeSkill = new EmployeeSkill();

				Optional<ServiceCategory>serviceEntity = serviceRepo.findServiceByName(profession);
			
				employeSkill.setServiceCategory(serviceEntity.get());
				employeSkill.setServicename(profession);
				employeSkill.setHourlyRate(serviceEntity.get().getBaseRate());
				employeSkill.setEmployee(savedEmployeeEntity);
				
				employeeSkillRepo.save(employeSkill);
			}
			veriResp.setVerified(true);
		}
		else {
			veriResp.setVerified(false);
		}
		

		
	
		
		
		
	 return veriResp;
	 
	 
	}
	
	
	
}
