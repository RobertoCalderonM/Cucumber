package com.rcm.cucumber.configuration;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;


@Lazy @Component
public class DriverInstance {

    @Autowired
    WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @PreDestroy
    private void quitBrowser(){
        driver.quit();
    }

}
