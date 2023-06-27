@LoginPage
Feature: Login

  @User @Login @Positive
  Scenario: User login to Nusameals
    Given User open Nusameals app
    And User input Username "Basmaronanta"
    And User input Password "mylove366"
    And User click Login button
    Then User see login Success message

  @User @Login @Negative
  Scenario: User login to Nusameals without username and password
    Given User open Nusameals app
    And User input Username ""
    And User input Password ""
    And User click Login button
    Then User see login Failed message