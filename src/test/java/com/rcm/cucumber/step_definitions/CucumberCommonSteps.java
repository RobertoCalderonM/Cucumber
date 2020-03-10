package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.configuration.SpringBootContextConfiguration;
import com.rcm.cucumber.manager.TestDataManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CucumberCommonSteps extends SpringBootContextConfiguration {

    @Autowired
    TestDataManager testDataManager;

    @Before
    public void beforeScenario(Scenario scenario){
        testDataManager.setScenario(scenario);
        log.info(String.format("Starting Scenario: %s...",scenario.getName()));
    }

    @After
    public void afterScenario(Scenario scenario){
        log.info(String.format("Finishing Scenario: %s...",scenario.getName()));
    }

}
