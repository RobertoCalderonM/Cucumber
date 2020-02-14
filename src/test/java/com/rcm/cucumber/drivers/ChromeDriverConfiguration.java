package com.rcm.cucumber.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class ChromeDriverConfiguration extends ChromeDriver {
    static { System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");}
}
