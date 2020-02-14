package com.rcm.cucumber.step_definitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CommonSteps {


    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println(String.format("Starting Scenario: %s...",scenario.getName()));
    }

    @After
    public void afterScenario(Scenario scenario){
        System.out.println(String.format("Finishing Scenario: %s...",scenario.getName()));
    }


}
