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

	@Query("SELECT k FROM RegisterAsCustomerEntity k WHERE k.email = :email AND k.password = :password")
	Optional<RegisterAsCustomerEntity> searchByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	@Query("SELECT k FROM RegisterAsCustomerEntity k WHERE k.phone = :phone AND k.password = :password")
	Optional<RegisterAsCustomerEntity> searchByPhoneNoAndPassword(@Param("phone") String phone, @Param("password") String password);

}
