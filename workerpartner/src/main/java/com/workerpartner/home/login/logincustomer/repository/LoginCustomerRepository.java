package com.workerpartner.home.login.logincustomer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;

@Repository
public interface LoginCustomerRepository extends JpaRepository<RegisterAsCustomerEntity, Long> {

	@Query("SELECT k FROM RegisterAsCustomerEntity k WHERE k.email = :email")
	Optional<RegisterAsCustomerEntity> searchByEmail(@Param("email") String email);
	
	@Query("SELECT k FROM RegisterAsCustomerEntity k WHERE k.phone = :phone")
	Optional<RegisterAsCustomerEntity> searchByPhoneNo(@Param("phone") String phone);

}
