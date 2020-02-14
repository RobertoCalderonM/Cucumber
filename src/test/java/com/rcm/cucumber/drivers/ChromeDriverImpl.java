package com.rcm.cucumber.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverImpl extends ChromeDriver {

    static{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    }

    public ChromeDriverImpl() {
        super();
    }
}
