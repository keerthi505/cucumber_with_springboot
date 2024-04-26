package com.keerthi.cucumberrestapi.steps;

import com.keerthi.cucumberrestapi.CucumberRestapiApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes= CucumberRestapiApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberConfiguration {
}
