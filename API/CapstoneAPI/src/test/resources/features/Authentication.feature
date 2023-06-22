Feature: Users started to use Nusameal

  @NusamealAPI @Register @Positive
  Scenario: Users register to Nusameal
    Given User call an api "register" with method "POST" with payload below
      | username    | email     | password     | retype_password |
      | disti10 | disti500@email.com | disti303   | disti303 |
    Then User verify status code is 200

  @NusamealAPI @Login @Positive
  Scenario: Users login to Nusameal correct email password
    Given User call an api "login" with method "POST" with payload below
      | email_or_username       | password         |
      | disti10 | disti303  |
    Then User verify status code is 200

  @NusamealAPI @Login @Negative
  Scenario: Users login to Nusameal wrong email password
    Given User call an api "login" with method "POST" with payload below
      | email_or_username       | password         |
      | disti2 | disti299  |
    Then User verify status code is 400