package com.rcm.cucumber.step_definitions;

import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class BrowserSteps {

    @Autowired
    WebDriver driver;

    @When("User navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
        log.info("Navigating to: "+url);
    }
}
