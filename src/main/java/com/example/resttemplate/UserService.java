package com.example.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    String url = "http://91.241.64.178:7081/api/users";
    RestTemplate restTemplate = new RestTemplate();
    String cookie = null;
    HttpHeaders requestHeaders = new HttpHeaders();

    public void allUsers() {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        HttpHeaders headers = response.getHeaders();
        System.out.println(response);
        cookie = headers.getFirst(headers.SET_COOKIE);
        System.out.println("cookie " + cookie);
    }

    public void add(User user) {
        requestHeaders.add("Cookie", cookie);
        HttpEntity<User> requestBody = new HttpEntity<>(user, requestHeaders);
        // Send request with POST method.
        ResponseEntity<String> result = restTemplate.postForEntity(url, requestBody, String.class);
        System.out.println("добавлен " + result.getBody());
    }

    public void update(User user){
//        requestHeaders.add("Cookie", cookie);
        HttpEntity<User> requestBody = new HttpEntity<>(user, requestHeaders);
        String result =  restTemplate.exchange(url, HttpMethod.PUT, requestBody, String.class).getBody();
        System.out.println("изменен " + result);
    }

    public void delete(long id) {
//        requestHeaders.add("Cookie", cookie);
        HttpEntity<User> requestBody = new HttpEntity<>(requestHeaders);
        String result =  restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, requestBody, String.class).getBody();
        System.out.println("удален " + result);


    }
}
