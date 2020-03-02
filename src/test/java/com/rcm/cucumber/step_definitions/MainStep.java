package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.configuration.DriverInstance;
import com.rcm.cucumber.configuration.SpringBootContextConfiguration;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;



public class MainStep extends SpringBootContextConfiguration {

    @Autowired
    DriverInstance driverInstance;

    @When("User navigates to {string}")
    public void userNavigatesTo(String url) {
        driverInstance.getDriver().get(url);
    }
}
