Feature: Test Login flow of application

  Background: Making the setUp ready
    Given Do the Intial SetUP

  @chrome @Regression
  Scenario: Login with valid credentials in chrome
    Given Launching A Particular 'chrome'
    Given User Launch's the 'HOMEPAGE_URL'
    When  User enter a valid 'username'
    When  User enter a valid 'password'
    Then  User click on login
    And   Verify the landing on home page
    And   Shoutdown Browser

  @Edge @Regression
  Scenario: Login with valid credentials in edge
    Given Launching A Particular 'edge'
    Given User Launch's the 'HOMEPAGE_URL'
    When  User enter a valid 'username'
    When  User enter a valid 'password'
    Then  User click on login
    And   Verify the landing on home page
    And   Shoutdown Browser