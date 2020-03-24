Feature: Choose a Topic
  Allowing a student to choose a topic in a certain level

  Scenario: Choose a topic in a certain level as a student
    Given I navigate to the page with available topics for a level as a student
    And I click on the topic that I want to study
    Then I should see the page with theory and questions for the topic I chose

