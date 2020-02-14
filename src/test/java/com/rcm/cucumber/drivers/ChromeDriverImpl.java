package com.rcm.cucumber.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ChromeDriverImpl extends ChromeDriver {

    static{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    }

    public ChromeDriverImpl() {
        super();
    }
}
