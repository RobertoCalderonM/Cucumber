package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.configuration.DriverInstance;
import com.rcm.cucumber.configuration.SpringBootContextConfiguration;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class MainStep {

    @Autowired
    DriverInstance driverInstance;

    @When("User navigates to {string}")
    public void userNavigatesTo(String url) {
        driverInstance.getDriver().get(url);
        log.info("Navigating to: "+url);
    }
}
