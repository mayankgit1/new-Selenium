Feature: Login Functionality

  Scenario: Check login is successful with valid credentials.
    Given user is on login page
     When user enters username, password and gallerypin
      And click to login button
      And user validate to 2FA page
     Then user is navigate to the dashboard page
