package com.rcm.cucumber.configuration;
import com.rcm.cucumber.CucumberApplication;
import com.rcm.cucumber.database.configuration.BaseDatabaseConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = CucumberApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext
@TestPropertySource(locations = {"classpath:test.configuration.properties"})
public class SpringBootContextConfiguration {
}
