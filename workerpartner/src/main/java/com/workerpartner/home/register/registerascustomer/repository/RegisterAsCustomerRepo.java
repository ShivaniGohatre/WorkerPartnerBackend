package com.workerpartner.home.register.registerascustomer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;

public interface RegisterAsCustomerRepo extends JpaRepository<RegisterAsCustomerEntity, Long> {

	@Query("SELECT k FROM RegisterAsCustomerEntity k WHERE k.email = :email")
	Optional<RegisterAsCustomerEntity> searchByEmail(@Param("email") String email);
	
}
