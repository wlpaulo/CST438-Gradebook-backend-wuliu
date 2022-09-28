package com.cst438.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cst438.domain.Assignment;
import com.cst438.domain.AssignmentRepository;

@Service
public class AssignmentService {
	private final AssignmentRepository assignmentRepository;

	public AssignmentService(AssignmentRepository assignmentRepository) {
		super();
		this.assignmentRepository = assignmentRepository;
	}
	
	@Transactional
	public Assignment save(Assignment assignment) {
		
		return assignmentRepository.save(assignment);
		
		
	}

}
