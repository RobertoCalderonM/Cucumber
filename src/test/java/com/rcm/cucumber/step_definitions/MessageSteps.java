package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.manager.TestDataManager;
import com.rcm.cucumber.entity.User;
import io.cucumber.java.en.But;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

@Slf4j
public class MessageSteps {

    @Autowired
    TestDataManager testDataManager;
    @Autowired
    SoftAssertions softAssertions;

    @When("User says {string} and sleeps {int} milliseconds")
    public void userSays(String message, int milliseconds) throws InterruptedException {
        User user=testDataManager.getUser();
        log.info(String.format("%s %s says: %s and sleeps %s milliseconds",user.getFirstName(),user.getLastName(),message, milliseconds));
        Thread.sleep(milliseconds);
    }

    @When("User profile:")
    public void userProfile(Map<String,String> details) {
        User user=new User();
        user.setFirstName(details.get("First Name"));
        user.setLastName(details.get("Last Name"));
        log.info("Setting in TestDataManager: "+ user);
        testDataManager.setUser(user);
    }

    @But("I like to fail softly!")
    public void failSoftly(){
        softAssertions.fail("I like to fail! :D");
    }
}
