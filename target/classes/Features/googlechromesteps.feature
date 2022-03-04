Feature: to test google search functionality

  Scenario: check if the google search feature functions correctly
    Given new browser is open
    And user is on home page
    When user enters a text search page
    And user clicks on the search button
    Then user is navigated to the search results