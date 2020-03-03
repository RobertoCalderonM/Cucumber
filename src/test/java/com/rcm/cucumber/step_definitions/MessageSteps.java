package com.rcm.cucumber.step_definitions;

import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageSteps {

    @When("User says {string} and sleeps")
    public void userSays(String message) throws InterruptedException {
        log.info(String.format("User says: %s and sleeps 5000ms",message));
        Thread.sleep(5000);
    }
}
