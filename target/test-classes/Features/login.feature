Feature: feature to test login functionality

  Scenario: check login is successful with valid credentials
    Given browswer is open
    And user is on login page
    When user enters username and password
    And user clicks on login button
    Then user is be navigated to the home page

