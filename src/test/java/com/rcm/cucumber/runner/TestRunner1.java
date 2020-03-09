package com.rcm.cucumber.runner;

import com.rcm.cucumber.configuration.DriverInitialization;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome=false,
        plugin = {"pretty", "summary","de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        strict = true,
        snippets = CAMELCASE,
        tags = {"@tagTest1 or @tagTest2"},
        features= {"src/test/resources/features"},
        extraGlue={"com.rcm.cucumber.step_definitions"})
public class TestRunner1 {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Starting Test...");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Finishing Test...");
    }

}
