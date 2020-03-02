package com.rcm.cucumber.configuration;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
public class DriverInstance {
    WebDriver driver;

    @Autowired
    DriverInitialization driverInitialization;

    @Bean
    public void initializeDriver() throws IOException {
        driver=driverInitialization.initializeBrowser();
    }

    public WebDriver getDriver(){
        return driver;
    }

    @PreDestroy
    private void quitBrowser(){
        driver.quit();
    }

}
