package com.rcm.cucumber.configuration.properties.test;

import com.rcm.cucumber.configuration.properties.test.child.Browser;
import com.rcm.cucumber.configuration.properties.test.child.OS;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="test")
public class TestConfigurationProperties {
    private String environment;
    private String machine;

    @Autowired @Qualifier("testOS")
    private OS os;
    @Autowired @Qualifier("testBrowser")
    private Browser browser;

    @Bean("testOS") @ConfigurationProperties(prefix="os")
    OS registerOs(){return new OS();}

    @Bean("testBrowser") @ConfigurationProperties(prefix="browser")
    public Browser registerBrowser(){return new Browser();}

}
