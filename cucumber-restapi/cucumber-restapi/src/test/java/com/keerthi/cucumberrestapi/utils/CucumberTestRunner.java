package com.keerthi.cucumberrestapi.utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/main/resources/features",
        glue="com.keerthi.cucumberrestapi.steps"
)
public class CucumberTestRunner {

}
