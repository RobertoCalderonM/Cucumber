package com.rcm.cucumber.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class DriverInitialization {

    @Autowired
    TestConfigurationProperties testConfigurationProperties;

     WebDriver initializeBrowser() throws IOException {
        String machineProperty=testConfigurationProperties.getTestMachine();
        switch (machineProperty){
            case "local":
                return localBrowser();
            case "remote":
                return remoteBrowser();
            default:
                throw new IOException(String.format("Property: %s do not exists for test.browser",machineProperty));
        }
    }

    private WebDriver remoteBrowser() throws IOException {
        String browserProperty=testConfigurationProperties.getTestBrowser();
        DesiredCapabilities cap;
        switch (browserProperty){
            case "chrome":
                cap=DesiredCapabilities.chrome();
                break;
            default:
                throw new IOException(String.format("Property: %s do not exists for test.browser",browserProperty));
        }
        cap.setCapability("version","");
        cap.setCapability("platform","LINUX");
        return new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"),cap);
    }

    private WebDriver localBrowser() throws IOException {
        String browserProperty=testConfigurationProperties.getTestBrowser();
        switch (browserProperty){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new IOException(String.format("Property: %s do not exists for test.browser",browserProperty));
        }
    }
}
