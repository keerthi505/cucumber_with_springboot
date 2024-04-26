Feature: Retrieve API Version
  Scenario: Get the API Version
    When I request the endpoint "/version"
    Then the response should be "0.0.1"
    And the status code is 200