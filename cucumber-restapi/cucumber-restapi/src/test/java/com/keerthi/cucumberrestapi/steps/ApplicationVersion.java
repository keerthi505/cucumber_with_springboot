package com.keerthi.cucumberrestapi.steps;

import com.keerthi.cucumberrestapi.utils.FeatureUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

//import static com.sun.imageio.plugins.jpeg.JPEG.version;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationVersion {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @When("I request the endpoint {string}")
    public void i_request_the_endpoint(String path) {
        // Write code here that turns the phrase above into concrete actions
       response=this.restTemplate.getForEntity(FeatureUtils.URL+path,String.class);
    }
    @Then("the response should be {string}")
    public void the_response_should_be(String version) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(version,response.getBody());
    }
    @Then("the status code is {int}")
    public void the_status_code_is(Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }
}
