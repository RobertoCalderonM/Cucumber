package com.rcm.cucumber.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
@Slf4j
@Component
public class TestConfigurationProperties {
    private Properties properties=new Properties();

    public TestConfigurationProperties(){
        initProperties();
    }

    private void initProperties(){
        String path = "src/test/resources/test.properties";
        log.info("Reading test properties from"+path);
        try(InputStream inputStream=new FileInputStream(path)){
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTestBrowser(){
        return properties.getProperty("test.browser");
    }

    public String getTestEnvironment(){
        return properties.getProperty("test.environment");
    }

    public String getTestMachine(){
        return properties.getProperty("test.machine");
    }

}
