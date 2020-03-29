Feature: Checking level existence

  Scenario: 10 Levels have been created at the start of the application
    Given The application has been started
    When I retrieve the list of levels
    Then The list has 10 levels