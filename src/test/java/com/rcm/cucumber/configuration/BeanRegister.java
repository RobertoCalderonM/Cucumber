package com.rcm.cucumber.configuration;

import com.rcm.cucumber.utils.ExtendedFluentWait;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.time.Duration;

@Slf4j @Component
public class BeanRegister {

    @Autowired
    DriverInitialization driverInitialization;

    @Autowired
    TestConfigurationProperties testConfigurationProperties;

    @Lazy @Bean
    public ExtendedFluentWait registerWait(@Autowired WebDriver driver){
        return (ExtendedFluentWait) new ExtendedFluentWait(driver)
                .pollingEvery(Duration.ofSeconds(5))
                .withTimeout(Duration.ofSeconds(40))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    @Lazy @Bean
    private WebDriver initializeBrowser() throws IOException {
        String machineProperty=testConfigurationProperties.getMachine();
        switch (machineProperty){
            case "local":
                log.info("Initializing local Browser...");
                return driverInitialization.getLocalBrowser();
            case "grid":
                log.info("Initializing grid Browser...");
                return driverInitialization.getGridBrowser();
            case "sauce_labs":
                log.info("Initializing Sauce Labs Browser...");
                return driverInitialization.getSauceLabsBrowser();
            default:
                throw new IOException(String.format("Property: %s do not exists for test.machine",machineProperty));
        }
    }

}
