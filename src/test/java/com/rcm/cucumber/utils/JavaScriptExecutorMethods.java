package com.rcm.cucumber.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class JavaScriptExecutorMethods {

    @Autowired @Lazy
    @Qualifier("JavascriptExecutor")
    JavascriptExecutor js;

    public Boolean highlightElement(WebElement element){
        log.debug("Highlighting element: "+element);
        try{
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');",element);
            return true;
        }catch(JavascriptException e){
            log.warn(e.getLocalizedMessage());
            return false;
        }
    }

    public Boolean unhighlightElement(WebElement element){
        log.debug("Unenlightening element: "+element);
        try{
            js.executeScript("arguments[0].setAttribute('style', 'border: 0px solid red;');",element);
            return true;
        }catch(JavascriptException e){
            log.warn(e.getLocalizedMessage());
            return false;
        }
    }
}
