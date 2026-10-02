package com.workerpartner.sequenceGeneration.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workerpartner.sequenceGeneration.entities.IdSequence;

import jakarta.persistence.LockModeType;

public interface IdSequenceRepository extends JpaRepository<IdSequence, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)   // SELECT ... FOR UPDATE
    @Query("SELECT s FROM IdSequence s WHERE s.seqName = :name")
    Optional<IdSequence> findByNameForUpdate(@Param("name") String name);
}