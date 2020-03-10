package com.rcm.cucumber.configuration;

import com.rcm.cucumber.manager.TestDataManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.URL;

@Slf4j
@Component
public class DriverInitialization {

    @Autowired
    TestConfigurationProperties testConfigurationProperties;

    @Autowired
    TestDataManager testDataManager;

    @Autowired @Lazy
    WebDriver driver;

    @PreDestroy
    private void quitBrowser(){
        if (driver!=null) driver.quit();
    }

    @Lazy @Bean
     private WebDriver initializeBrowser() throws IOException {
        String machineProperty=testConfigurationProperties.getMachine();
        switch (machineProperty){
            case "local":
                log.info("Initializing local Browser...");
                return getLocalBrowser();
            case "grid":
                log.info("Initializing grid Browser...");
                return getGridBrowser();
            case "sauce_labs":
                log.info("Initializing Sauce Labs Browser...");
                return getSauceLabsBrowser();
            default:
                throw new IOException(String.format("Property: %s do not exists for test.machine",machineProperty));
        }
    }

    private WebDriver getGridBrowser() throws IOException {
        String browserProperty=testConfigurationProperties.getBrowser();
        DesiredCapabilities cap;
        switch (browserProperty){
            case "chrome":
                cap=DesiredCapabilities.chrome();
                break;
            default:
                throw new IOException(String.format("Property: %s do not exists for test.browser for grid",browserProperty));
        }
        cap.setCapability("version","");
        cap.setCapability("platform","LINUX");
        return new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"),cap);
    }

    private WebDriver getLocalBrowser() throws IOException {
        String browserProperty=testConfigurationProperties.getBrowser();
        switch (browserProperty){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new IOException(String.format("Property: %s do not exists for test.browser for local machine",browserProperty));
        }
    }

    private WebDriver getSauceLabsBrowser() throws  IOException{
        String browserProperty=testConfigurationProperties.getBrowser();
        String sauceUserName = "Huayacayo";
        String sauceAccessKey = "d6dec3cf-8b02-44ed-81c5-3745de594030";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", sauceUserName);
        capabilities.setCapability("accessKey", sauceAccessKey);
        switch (browserProperty){
            case "safari":
                capabilities.setCapability("browserName", "Safari");
                capabilities.setCapability("platform", "macOS 10.13");
                capabilities.setCapability("version", "11.1");
                capabilities.setCapability("name",testDataManager.getScenario().getName());
                return new RemoteWebDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub"), capabilities);
            default:
                throw new IOException(String.format("Property: %s do not exists for test.browser for sauce_labs",browserProperty));
        }
        }
}
