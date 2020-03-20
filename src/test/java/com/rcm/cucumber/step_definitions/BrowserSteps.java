package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.page.webpages.AmazonPage;
import com.rcm.cucumber.page.webpages.GooglePage;
import com.rcm.cucumber.utils.ExtendedFluentWait;
import com.rcm.cucumber.utils.JavaScriptExecutorMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BrowserSteps {

    @Autowired
    WebDriver driver;
    @Autowired
    ExtendedFluentWait waiting;
    @Autowired
    GooglePage google;
    @Autowired
    AmazonPage amazon;

    @When("User navigates to {string}")
    public void userNavigatesTo(String url) {
        log.info("Navigating to: "+url);
        driver.get(url);
    }

    @Then("I say {string} to Google!")
    public void sayToGoogle(String value){
        waiting.untilElementToBeVisible(google.getGoogleSearchBar());
        google.googleSearchBarSendKeys(value);
    }

    @Then("I say {string} to Amazon!")
    public void sayToAmazon(String value){
        waiting.untilElementToBeVisible(amazon.getAmazonSearchBar());
        amazon.amazonSearchBarSendKeys(value);

    }

    @Then("Browser is refreshed")
    public void refreshBrowser(){
        log.info("Refreshing Browser...");
        driver.navigate().refresh();
    }


}
