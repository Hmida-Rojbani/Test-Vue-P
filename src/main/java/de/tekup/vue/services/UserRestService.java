package de.tekup.vue.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import de.tekup.vue.models.dto.User;


@Service
public class UserRestService {
	private static final String URL = "http://localhost:4000/api/users";
	public void sendUserToDB(User request) {
		RestTemplate template = new RestTemplate();
		try {
			ResponseEntity<User> response = template.postForEntity(URL, request, User.class);
		
			System.out.println("User " +response.getBody());
		
		}catch (HttpClientErrorException e) {
			// TODO: handle exception
			System.err.println("there is an error : "+ e.getResponseBodyAsString());
		}
		
		
	}
}

