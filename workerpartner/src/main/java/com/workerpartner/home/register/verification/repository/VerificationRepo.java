package com.workerpartner.home.register.verification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.workerpartner.home.register.verification.entity.KYCMasterData;
@Repository
public interface VerificationRepo extends JpaRepository<KYCMasterData, Long> {

	//JPQL
	@Query("SELECT k FROM KYCMasterData k WHERE k.name = :name AND k.aadharNumber = :aadharNumber")
	Optional<KYCMasterData> searchByNameAndAadhar(@Param("name") String name, @Param("aadharNumber") String aadharNumber);
	
//SQL	
//	@Query(value = "SELECT * FROM kyc_master_data WHERE name = :name AND aadhar_number = :aadharNumber", 
//		       nativeQuery = true)
//		Optional<KycMasterData> searchByNameAndAadhar(@Param("name") String name, @Param("aadharNumber") String aadharNumber);
}
