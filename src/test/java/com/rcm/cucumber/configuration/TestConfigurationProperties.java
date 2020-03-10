package com.rcm.cucumber.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="test")
public class TestConfigurationProperties {
    private String environment;
    private String machine;

    @Autowired
    private OS os;
    @Autowired
    private Browser browser;

    @Bean @ConfigurationProperties(prefix="os")
    OS getOs(){return new OS();}

    @Bean @ConfigurationProperties(prefix="browser")
    Browser getBrowser(){return new Browser();}

}

@Data
class OS{
    private String name;
    private String version;
}

@Data
class Browser{
    private String name;
    private String version;
}
