package com.workerpartner.home.login.loginemployee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.home.register.verification.entity.KYCMasterData;

@Repository
public interface LoginEmployeeRepository extends JpaRepository<EmployeeEntities,Long>{
	
	@Query("SELECT k FROM EmployeeEntities k WHERE k.email = :email AND k.password = :password")
	Optional<EmployeeEntities> searchByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	@Query("SELECT k FROM EmployeeEntities k WHERE k.phone = :phone AND k.password = :password")
	Optional<EmployeeEntities> searchByPhoneNoAndPassword(@Param("phone") String phone, @Param("password") String password);

}

