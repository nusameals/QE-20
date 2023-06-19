Feature: Login
  As a user
  I want to make the transaction
  So that I can login to application

  @login
  Scenario: user input with valid Username and password
    Given I am on the login page
    When I enter Username "admin"
    And I enter Password "mypassword"
    And I click SigIn button
    Then I am on the home page

  Scenario: user input with valid Username and invalid password
    Given I am on the login page
    When I enter Username "admin"
    And I enter Password "kelompok20"
    And I click SigIn button
    Then I can see error message "Incorrect username or password, please try again"

  Scenario: user input with invalid Username and valid password
    Given I am on the login page
    When I enter Username "kelompok20"
    And I enter Password "mypassword"
    And I click SigIn button
    Then I can see error message "Incorrect username or password, please try again"