package com.workerpartner.sequenceGeneration.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.workerpartner.sequenceGeneration.constants.SequenceTypes;
import com.workerpartner.sequenceGeneration.entities.IdSequence;
import com.workerpartner.sequenceGeneration.repo.IdSequenceRepository;

@Service
public class SequenceGeneratorService {

	private IdSequenceRepository idSequenceRepository;
	
	public SequenceGeneratorService(IdSequenceRepository idSequenceRepository) {
		this.idSequenceRepository=idSequenceRepository;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String sequenceGeneration(SequenceTypes types) {
		 IdSequence idSquence = idSequenceRepository.
				 findByNameForUpdate(types.getPrefix()).orElseThrow(()-> new IllegalArgumentException(
						 "Sequence is not configured"+" "+ types.getPrefix()));
			Long nextVal = idSquence.getNextVal()+1;
			idSquence.setNextVal(nextVal); //// saved automatically on commit
			String prefixWithNextVal = types.getPrefix()+nextVal;
			return prefixWithNextVal;
	}
	
}
