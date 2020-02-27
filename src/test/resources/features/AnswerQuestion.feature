Feature: Answer a question
  In order to use the app
  As a student
  I want to answer a question

  Scenario: Answer a question as student with the right answer
    Given I login as "student" with password "password" and role "student"
    And the answer is "answer"
    When I answer the question with answer "answer"
    Then The response code is 201
    And