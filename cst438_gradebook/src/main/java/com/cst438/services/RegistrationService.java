package com.cst438.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.cst438.domain.CourseDTOG;


public class RegistrationService {
	
	@Value("${registration.url}")
	private String registrationUrl;
	
	public void sendFinalGrades(int course_id , CourseDTOG courseDTO) {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = 
				registrationUrl + '/' + "course/" + course_id;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<CourseDTOG> requestUpdate = new HttpEntity<>(courseDTO, headers);
		restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
	}

}
