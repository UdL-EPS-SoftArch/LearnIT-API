Feature: Checking Topics existence

  Scenario: 5 Topics have been created in each Level at the start of the application
    Given The application has been started
    When I retrieve the list of topics for level 1
    Then The level has 5 topics

  Scenario: Level contains topic Topic
    Given There is level 1
    Then It contains topic with name "IT"