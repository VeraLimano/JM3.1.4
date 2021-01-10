package com.example.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {


	public static void main(String[] args) {

		User user = new User(3L, "James", "Brown", (byte)26);
		User user2 = new User(3L, "Thomas", "Shelby", (byte)26);

		SpringApplication.run(RestTemplateApplication.class, args);

		UserService userService = new UserService();

		userService.allUsers();

		userService.add(user);

		userService.update(user2);

		userService.delete(3L);



	}

}
