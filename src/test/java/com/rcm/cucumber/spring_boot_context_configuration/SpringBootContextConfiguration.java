package com.rcm.cucumber.spring_boot_context_configuration;
import com.rcm.cucumber.CucumberApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.PostConstruct;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = CucumberApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringBootContextConfiguration {

}
