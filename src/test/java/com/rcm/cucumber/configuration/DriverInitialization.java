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
    SauceLabsCredentialsProperties sauceLabsCredentialsProperties;

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
        String browserProperty=testConfigurationProperties.getBrowser().getName();
        DesiredCapabilities cap;
        switch (browserProperty){
            case "chrome":
                cap=DesiredCapabilities.chrome();
                break;
            case "firefox":
                cap=DesiredCapabilities.firefox();
                break;
            default:
                throw new IOException(String.format("Property: %s do not exists for test.browser for grid",browserProperty));
        }
        cap.setCapability("version","");
        cap.setCapability("platform","LINUX");
        return new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"),cap);
    }

    private WebDriver getLocalBrowser() throws IOException {
        String browserProperty=testConfigurationProperties.getBrowser().getName();
        switch (browserProperty){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new IOException(String.format("Property: %s do not exists for test.browser for local machine",browserProperty));
        }
    }

    private WebDriver getSauceLabsBrowser() throws  IOException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", sauceLabsCredentialsProperties.getUsername());
        capabilities.setCapability("accessKey", sauceLabsCredentialsProperties.getPassword());
        capabilities.setCapability("browserName", testConfigurationProperties.getBrowser().getName());
        capabilities.setCapability("os", testConfigurationProperties.getOs().getName());
        capabilities.setCapability("os_version", testConfigurationProperties.getOs().getVersion());
        capabilities.setCapability("browser_version", testConfigurationProperties.getBrowser().getVersion());
        capabilities.setCapability("name",testDataManager.getScenario().getName());
        return new RemoteWebDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub"), capabilities);
        }
}
