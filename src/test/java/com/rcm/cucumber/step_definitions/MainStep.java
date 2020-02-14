package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.spring_boot_context_configuration.SpringBootContextConfiguration;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;



public class MainStep extends SpringBootContextConfiguration {

    @Autowired
    WebDriver driver;

    @When("User navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }
}
