package com.rcm.cucumber.configuration;
import com.rcm.cucumber.CucumberApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = CucumberApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class
SpringBootContextConfiguration {

}
