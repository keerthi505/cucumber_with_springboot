package com.keerthi.cucumberrestapi.steps;

import com.keerthi.cucumberrestapi.model.Account;
import com.keerthi.cucumberrestapi.utils.FeatureUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountRegistartion {
    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<Long> response;
    private Account mockedAccount;

    @Given("the user provides valid account details")
    public void theUserProvidesValidAccountDetails() {

        mockedAccount = FeatureUtils.getMockAccount();
    }

    @When("the user sends a POST request to {string}")
    public void theUserSendsAPOSTRequestTo(String path) {
        response = this.restTemplate.postForEntity(FeatureUtils.URL + path, mockedAccount, Long.class);
    }

    @Then("the response status code of account registration should be {int}")
    public void theResponseStatusCodeOfAccountRegistrationShouldBe(int statusCode) {
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }

    @And("the response body should contain the created account ID {long}")
    public void theResponseBodyShouldContainTheCreatedAccountID(long id) {

        assertEquals(id, response.getBody());
    }
}
