package com.rcm.cucumber.page.webpages;

import com.rcm.cucumber.page.structure.PageObject;
import com.rcm.cucumber.utils.JavaScriptExecutorMethods;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component @Lazy @Getter @Slf4j
public class AmazonPage extends PageObject {

    @Autowired
    JavaScriptExecutorMethods js;

    public AmazonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement amazonSearchBar;

    public void amazonSearchBarSendKeys(String value){
        log.info("Sending keys to search bar: "+value);
        js.highlightElement(amazonSearchBar);
        amazonSearchBar.sendKeys(value);
    }
    public String amazonSearchBarGetText(){
        String value=amazonSearchBar.getText();
        log.info("Text retrieved from search bar: "+value);
        return value;
    }

}
