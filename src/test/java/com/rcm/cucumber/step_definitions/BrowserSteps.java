package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.page.structure.PageObject;
import com.rcm.cucumber.page.webpages.AmazonPage;
import com.rcm.cucumber.page.webpages.GooglePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class BrowserSteps {

    @Autowired
    WebDriver driver;

    @Autowired
    GooglePage google;

    @Autowired
    AmazonPage amazon;

    @When("User navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
        log.info("Navigating to: "+url);
    }

    @Then("I say {string} to Google!")
    public void sayToGoogle(String value){
        google.getGoogleSearchBar().sendKeys(value);
    }

    @Then("I say {string} to Amazon!")
    public void sayToAmazon(String value){
        amazon.getAmazonSearchBar().sendKeys(value);
    }

    @Then("Browser is refreshed")
    public void refreshBrowser(){
        driver.navigate().refresh();
    }


}
