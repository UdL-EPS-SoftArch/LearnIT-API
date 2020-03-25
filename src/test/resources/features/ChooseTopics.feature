Feature: Choose a Topic
  Allowing a student to choose a topic in a certain level

  Scenario: Choose a topic in a certain level as a student
    Given I navigate to the page with available topics for level "Level" as student with the username "Username"
    And I click on the topic "Topic" which I want to study
    Then I should see the page with available theory and questions for the topic I chose

  Scenario: I complete a topic in a certain level as a student
    Given I have chosen the topic "Topic" in level "Level" as student with username "Username"
    And I have successfully completed this topic
    Then I am awarded points for completing the topic

  Scenario: Completed set of 5 topics and all tests in a level
    Given I have as student with username "Username" completed 5 topics "Topic" in level "Level"
    And I have completed all the tests "Tests" along the level
    Then I am awarded a certificate of completion of this level
    And I am transferred to the next level "LevelNext"

  Scenario:

