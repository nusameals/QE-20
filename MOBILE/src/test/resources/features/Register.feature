@RegisterPage
Feature: Register

  @User @Register @Positive
  Scenario: User make account in Nusameals app
    Given User open Nusameals app
    And User click create account
    And User input Username "Basmaronanta"
    And User input Email "basmatest@gmail.com"
    And User input Password "mylove366"
    And User input Confirm Password "mylove366"
    And User click Create Account button
    Then User see Create Account Success message

  @User @Register @Negative
  Scenario: User make account in Nusameals app without capital letters in first username
    Given User open Nusameals app
    And User click create account
    And User input Username without capital letters "basmaronanta"
    And User input Email "basmatest@gmailcom"
    And User input Password "mylove366"
    And User input Confirm Password "mylove366"
    And User click Create Account button
    Then User see Insert a valid email message