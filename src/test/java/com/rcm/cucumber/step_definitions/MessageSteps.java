package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.manager.TestDataManager;
import com.rcm.cucumber.entity.User;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

@Slf4j
public class MessageSteps {

    @Autowired
    TestDataManager testDataManager;

    @When("User says {string} and sleeps")
    public void userSays(String message) throws InterruptedException {
        User user=testDataManager.getUser();
        log.info(String.format("%s %s says: %s and sleeps 3000ms",user.getFirstName(),user.getLastName(),message));
        Thread.sleep(3000);
    }

    @When("User profile:")
    public void userProfile(Map<String,String> details) {
        User user=new User();
        user.setFirstName(details.get("First Name"));
        user.setLastName(details.get("Last Name"));
        log.info("Setting in TestDataManager: "+ user);
        testDataManager.setUser(user);
    }
}
