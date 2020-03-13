package com.rcm.cucumber.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import java.time.Clock;


public class ExtendedFluentWait extends FluentWait<WebDriver> {

    public ExtendedFluentWait(WebDriver input) {
        super(input);
    }

    public ExtendedFluentWait(WebDriver input, Clock clock, Sleeper sleeper) {
        super(input, clock, sleeper);
    }

    public WebElement untilElementToBeClickable(WebElement element){
        return this.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement untilElementToBeVisible(WebElement element){
        return this.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean untilElementToNotBeVisible(WebElement element){
        return this.until(ExpectedConditions.invisibilityOf(element));
    }

}
