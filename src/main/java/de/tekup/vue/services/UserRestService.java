package de.tekup.vue.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import de.tekup.vue.models.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class UserRestService {
	private static final String URL = "http://localhost:4000/api/users";
	public void sendUserToDB(User request) {
		RestTemplate template = new RestTemplate();
		try {
			ResponseEntity<Object> response = template.postForEntity(URL, request, Object.class);
		if (response.getStatusCodeValue()==200) {
			System.out.println("User " +(User)response.getBody());
		}else {
			System.out.println("Error" + response.getBody());
		}
		}catch (HttpClientErrorException e) {
			// TODO: handle exception
			System.err.println("there is an error");
		}
		
		
	}
}

@Data
@AllArgsConstructor
class ErrorRes{
	private String msgErrors;
}
