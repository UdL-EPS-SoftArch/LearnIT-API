Feature: Delete a question
  In order to use the app
  As a teacher
  I want to delete an existing question

  Scenario: Delete a question as teacher
    Given I login as "teacher" with password "password" and role "teacher"
    And question with id "O" exists
    When I delete the question with id "0"
    Then The response code is 201
    And It has been deleted the question with id "0"

  Scenario: Delete a question as student
    Given I login as "student" with password "password" and role "student"
    And question with id "O" exists
    When I delete the question with id "0"
    Then The response code is 401
    And It has not been deleted the question with id "0"

  Scenario: Delete a question without login
    Given I'm not logged in
    And question with id "O" exists
    When I delete the question with id "0"
    Then The response code is 401
    And It has not been deleted the question with id "0"

  Scenario: Delete a not existing question as teacher
    Given I login as "teacher" with password "password" and role "teacher"
    And question with id "0" doesn't exist
    When I delete the question with id "0"
    Then The response code is 400