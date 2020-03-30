Feature: Checking level existence

  Scenario: 10 Levels have been created at the start of the application
    Given The application has been started
    When I retrieve the list of levels
    Then The list has 12 levels


  Scenario: Level 3 has been created at the start of the application
    Given The application has been started
    When I try to access level 3
    Then The response code is 200
