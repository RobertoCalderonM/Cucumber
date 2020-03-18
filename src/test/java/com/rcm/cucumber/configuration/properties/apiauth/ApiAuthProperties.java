package com.rcm.cucumber.configuration.properties.apiauth;

import com.rcm.cucumber.configuration.properties.apiauth.child.Admin;
import com.rcm.cucumber.configuration.properties.apiauth.child.App;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix="api.auth")
@PropertySource("classpath:api.auth.${spring.profiles.active}.properties")
public class ApiAuthProperties {
    @Autowired @Qualifier("apiAdmin")
    private Admin admin;
    @Autowired @Qualifier("apiApp")
    private App app;

    @Bean("apiAdmin") @ConfigurationProperties(prefix = "admin")
    Admin registerAdmin(){
        return new Admin();
    }

    @Bean("apiApp") @ConfigurationProperties(prefix = "app")
    App registerApp(){
        return new App();
    }

}