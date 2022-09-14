package com.cst438;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.cst438.controllers.GradeBookController;
import com.cst438.domain.Assignment;
import com.cst438.domain.AssignmentGradeRepository;
import com.cst438.domain.AssignmentRepository;
import com.cst438.domain.CourseRepository;
import com.cst438.services.RegistrationService;

@ContextConfiguration(classes = { GradeBookController.class })
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest

public class assignmentTest {
	static final String URL = "http://localhost:8080";
	public static final int TEST_COURSE_ID = 40442;
	public static final String TEST_STUDENT_EMAIL = "test@csumb.edu";
	public static final String TEST_STUDENT_NAME = "test";
	public static final String TEST_INSTRUCTOR_EMAIL = "dwisneski@csumb.edu";
	public static final int TEST_YEAR = 2021;
	public static final String TEST_SEMESTER = "Fall";
	public static final Date DUE_DATE= Date.valueOf("2022-11-10");

	@MockBean
	AssignmentRepository assignmentRepository;

	@MockBean
	AssignmentGradeRepository assignmentGradeRepository;

	@MockBean
	CourseRepository courseRepository; // must have this to keep Spring test happy

	@MockBean
	RegistrationService registrationService; // must have this to keep Spring test happy

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	GradeBookController bookController;
	
	@Test
	public void addAssignmentTest(){
		
		Assignment assignment = new Assignment();
		assignment.setDueDate(DUE_DATE);
		assignment.setName(TEST_STUDENT_NAME);
		try {
			when(assignmentRepository.save(assignment)).thenReturn(assignment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assignment assignment1 = bookController.addAssignment(TEST_STUDENT_NAME, DUE_DATE);
		assertEquals(assignment, assignment1);
	}
}
