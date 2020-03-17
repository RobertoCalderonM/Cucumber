package com.rcm.cucumber.configuration.properties.saucelabs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix="sauce")
@PropertySource("classpath:sauce_labs.credentials.properties")
public class SauceLabsCredentialsProperties {
    private String username;
    private String password;
}
