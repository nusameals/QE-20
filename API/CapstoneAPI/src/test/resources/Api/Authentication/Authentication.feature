Feature: Authentication

  Scenario: Register User using a valid full name, email and password
    Given I register using the correct data
    When I submit a POST request to "/auth/registeruser" with username "basmaronanta", email "basmaronanta@gmail.com" and password "kelompok20"
    Then I receive valid HTTP response code register 200
    And register successfully

  Scenario: Register Admin using a valid full name, email and password
    Given I register using the correct data
    When I submit a POST request to "/auth/registeradmin" with username "basma_admin", email "basma_admin@gmail.com" and password "kelompok20"
    Then I receive valid HTTP response code register 200
    And register successfully

  Scenario: Login with registered or correct email and password
    Given I have valid credentials
    When I submit a POST request to "/auth/login" with email "basmaronanta@gmail.com" and password "kelompok20"
    Then I receive valid HTTP response code Login 200

