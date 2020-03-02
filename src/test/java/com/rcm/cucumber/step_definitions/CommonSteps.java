package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.configuration.SpringBootContextConfiguration;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonSteps extends SpringBootContextConfiguration {

    @Before
    public void beforeScenario(Scenario scenario){
        log.info(String.format("Starting Scenario: %s...",scenario.getName()));
    }

    @After
    public void afterScenario(Scenario scenario){
        log.info(String.format("Finishing Scenario: %s...",scenario.getName()));
    }


}
