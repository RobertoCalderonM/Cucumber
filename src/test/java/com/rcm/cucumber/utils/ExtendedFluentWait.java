package com.rcm.cucumber.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import java.time.Clock;
import java.util.List;

@Slf4j
public class ExtendedFluentWait extends FluentWait<WebDriver> {

    public ExtendedFluentWait(WebDriver input) {
        super(input);
    }
    public ExtendedFluentWait(WebDriver input, Clock clock, Sleeper sleeper) {
        super(input, clock, sleeper);
    }

    public WebElement untilElementToBeClickable(WebElement element){
        log.info("Waiting element to be clickable: "+element);
        return this.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement untilElementToBeVisible(WebElement element){
        log.info("Waiting element to be visible: "+element);
        return this.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> untilAllElementsToBeVisible(List<WebElement> elementsList){
        log.info("Waiting elements to be visible... Size: "+elementsList.size());
        return this.until(ExpectedConditions.visibilityOfAllElements(elementsList));
    }

    public Boolean untilElementToNotBeVisible(WebElement element){
        log.info("Waiting element to not be visible: "+element);
        return this.until(ExpectedConditions.invisibilityOf(element));
    }

    public Boolean untilAllElementsNotToBeVisible(List<WebElement> elementsList){
        log.info("Waiting elements to not be visible... Size: "+elementsList.size());
        return this.until(ExpectedConditions.invisibilityOfAllElements(elementsList));
    }

    public Boolean untilTextIsPresentInElement(WebElement element,String text){
        log.info("Waiting element to contain text: "+text+", element: "+element);
        return this.until(ExpectedConditions.textToBePresentInElementValue(element,text));
    }

    public Boolean untilAttributeContains(WebElement element,String attribute,String value){
        log.info("Waiting element to contain attribute: "+attribute+", value: "+value+", element: "+element);
        return this.until(ExpectedConditions.attributeContains(element,attribute,value));
    }

}
