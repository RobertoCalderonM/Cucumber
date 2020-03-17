package com.rcm.cucumber.api.service;

import com.rcm.cucumber.api.models.Auth;
import com.rcm.cucumber.api.models.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component @Slf4j
public class ClientAPI {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AuthAPI authAPI;

    public Client getClientById(Long id){
        //Requesting token
        Auth value=authAPI.requestToken();
        log.info(String.format("Auth API response: %s",value));
        //Creating Headers
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(value.getAccessToken());
        HttpEntity<String> entity=new HttpEntity<>(headers);
        try {
            return restTemplate.exchange(String.format("http://localhost:8080/api/clients/%d", id), HttpMethod.GET, entity, Client.class)
                    .getBody();
        }catch (RestClientException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }

}
