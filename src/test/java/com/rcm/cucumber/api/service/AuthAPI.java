package com.rcm.cucumber.api.service;

import com.rcm.cucumber.api.models.Auth;
import com.rcm.cucumber.configuration.properties.apiauth.ApiAuthProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@Component @Slf4j
public class AuthAPI {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ApiAuthProperties apiAuthProperties;

    public Auth requestToken(){
        //Creating Headers
        HttpHeaders headers=new HttpHeaders();
        headers.setBasicAuth(apiAuthProperties.getApp().getName(),apiAuthProperties.getApp().getPassword());
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        //Creating Body
        MultiValueMap<String, String> bodyParamMap = new LinkedMultiValueMap<>();
        bodyParamMap.add("grant_type", "password");
        bodyParamMap.add("username", apiAuthProperties.getAdmin().getName());
        bodyParamMap.add("password", apiAuthProperties.getAdmin().getPassword());

        //Creating Entity
        HttpEntity<MultiValueMap<String,String>> entity=new HttpEntity<>(bodyParamMap,headers);

        log.info("Requesting Token...");
        try {
            return restTemplate.exchange("http://localhost:8080/oauth/token", HttpMethod.POST, entity, Auth.class)
                    .getBody();
        }catch (RestClientException e){
            log.error(e.getLocalizedMessage());
            throw e;
        }
    }
}
