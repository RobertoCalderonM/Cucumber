package com.rcm.cucumber.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="sauce")
public class SauceLabsCredentialsProperties {
    private String username;
    private String password;
}
