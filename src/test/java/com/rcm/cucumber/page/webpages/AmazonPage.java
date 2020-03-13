package com.rcm.cucumber.page.webpages;

import com.rcm.cucumber.page.structure.PageObject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component @Lazy @Getter @Slf4j
public class AmazonPage extends PageObject {

    public AmazonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement amazonSearchBar;

    public void amazonSearchBarSendKeys(String value){
        log.info("Sending keys to search bar: "+value);
        amazonSearchBar.sendKeys(value);
    }

}
