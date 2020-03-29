Feature: Checking level existence

  Scenario: 10 Levels have been created at the start of the application
    Given The application has been started
    When I retrieve the list of levels
    Then The list has 10 levels


  Scenario: Level 3 has been created at the start of the application
    Given There is a level with name 3
    When I try to access level 3
    Then The response code is 200
