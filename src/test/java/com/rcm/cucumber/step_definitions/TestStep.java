package com.rcm.cucumber.step_definitions;


import com.rcm.cucumber.drivers.ChromeDriverImpl;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class TestStep {

    WebDriver driver=new ChromeDriverImpl();

    @When("User navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }
}
