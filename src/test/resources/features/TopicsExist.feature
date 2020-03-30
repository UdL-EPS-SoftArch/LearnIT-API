Feature: Checking Topics existence

  Scenario: 5 Topics have been created in each Level at the start of the application
    Given The application has been started
    When I retrieve the list of topics for level 1
    Then The level has 0 topics