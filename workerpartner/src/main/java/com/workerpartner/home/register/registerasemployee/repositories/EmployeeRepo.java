package com.workerpartner.home.register.registerasemployee.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.workerpartner.home.register.registerascustomer.entities.RegisterAsCustomerEntity;
import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntities, Long> {

	@Query("SELECT k FROM EmployeeEntities k WHERE k.email = :email")
	Optional<EmployeeEntities> searchByEmail(@Param("email") String email);
}
