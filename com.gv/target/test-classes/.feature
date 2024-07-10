Feature: Login Feature

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters username "username" and password "password"
    And Clicks login button
    Then User is navigated to the home page
