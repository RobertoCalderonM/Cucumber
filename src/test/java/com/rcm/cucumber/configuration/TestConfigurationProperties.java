package com.rcm.cucumber.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="test")
public class TestConfigurationProperties {
    private String browser;
    private String environment;
    private String  machine;
}
