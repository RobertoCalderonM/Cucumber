package com.rcm.cucumber.utils;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j @Component
public class AssertionLogRegister {
    @Autowired
    SoftAssertions softAssertions;

    public void addSoftAssertionsToLog(){
        try{
            softAssertions.assertAll();
        }catch (SoftAssertionError e){
            log.warn(e.getLocalizedMessage());
            throw e;
        }
    }
}
