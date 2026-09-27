package com.workerpartner.home.register.registerasemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntities, Long> {

}
