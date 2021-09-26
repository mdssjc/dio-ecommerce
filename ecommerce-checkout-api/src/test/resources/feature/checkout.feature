Feature: Checkout Resource

  Scenario: create checkout
    When the client calls "/v1/checkout/"
    Then the client receives status code of 201
    And response contains "code"
