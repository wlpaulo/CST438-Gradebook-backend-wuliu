package com.cst438.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.cst438.domain.CourseDTOG;

public class RegistrationServiceREST extends RegistrationService {

	
	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${registration.url}") 
	String registration_url;
	
	public RegistrationServiceREST() {
		System.out.println("REST registration service ");
	}
	
	@Override
	public void sendFinalGrades(int course_id , CourseDTOG courseDTO) { 
		
		//TODO  complete this method in homework 4
		System.out.println("sending final grades " + course_id+" "+courseDTO);
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = 
				registration_url + '/' + "course/" + course_id;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<CourseDTOG> requestUpdate = new HttpEntity<>(courseDTO, headers);
		restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
	
		System.out.println("After sending final grades");
	}
}
