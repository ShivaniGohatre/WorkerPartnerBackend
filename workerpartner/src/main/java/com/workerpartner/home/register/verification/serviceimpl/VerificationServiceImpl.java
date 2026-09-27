package com.workerpartner.home.register.verification.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.workerpartner.home.register.verification.VerificationResponse;
import com.workerpartner.home.register.verification.entity.KYCMasterData;
import com.workerpartner.home.register.verification.repository.VerificationRepo;
import com.workerpartner.home.register.verification.service.VerificationService;

@Service
public class VerificationServiceImpl implements VerificationService{

	public VerificationRepo verificationRepo;
	
	public VerificationServiceImpl(VerificationRepo verificationRepo)
	{
		this.verificationRepo= verificationRepo;
	}
	
	@Override
	public VerificationResponse verifyAadhar(String name, String aadhar) {
		
		
		Optional<KYCMasterData> kycMasterData = verificationRepo.searchByNameAndAadhar(name, aadhar);
		
		VerificationResponse verificationResp= new VerificationResponse();
		if(kycMasterData.isEmpty() || kycMasterData == null)
		{
         
			verificationResp.setVerified(false);
			verificationResp.setMessage("Name or Aadhar not Verified");
		}
		else
		{
			verificationResp.setVerified(true);
			verificationResp.setMessage("Name and Aadhar  Verified");
			
		}
		
		return verificationResp;
	}
	

	
	
	
}
