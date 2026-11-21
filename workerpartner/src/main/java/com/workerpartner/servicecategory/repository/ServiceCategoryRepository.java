package com.workerpartner.servicecategory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workerpartner.home.register.registerasemployee.entities.EmployeeEntities;
import com.workerpartner.sequenceGeneration.entities.IdSequence;
import com.workerpartner.servicecategory.entity.ServiceCategory;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {

	
	// All active services, one page at a time
    Page<ServiceCategory> findByActiveTrue(Pageable pageable);
 
    // Same, filtered by name (used by the search-bar suggestions)
    Page<ServiceCategory> findByActiveTrueAndNameContainingIgnoreCase(String name, Pageable pageable);
    
    @Query(value = "SELECT S.NAME FROM SERVICE_CATEGORY S WHERE S.ACTIVE = '1' AND S.NAME IS NOT NULL", nativeQuery = true)
    List<String> findAllServiceCategory();
  
    @Query(value="SELECT S FROM ServiceCategory S WHERE S.name = :name")
    Optional<ServiceCategory> findServiceByName(@Param("name") String name);
    
	}

