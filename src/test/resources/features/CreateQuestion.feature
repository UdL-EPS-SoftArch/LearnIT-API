Feature: Create a question
  In order to use the app
  As a teacher
  I want to add a new question

  Scenario: Add a new question as teacher
    Given I login as "teacher" with password "password" and role "teacher"
    And question with statement "statement test" doesn't exist
    When I write a new question with statement "statement test", answer "answer test"
    Then The response code is 201
    And It has been created a question with statement "statement test" and answer "answer test"

  Scenario: Add a new question as student
    Given I login as "student" with password "password" and role "student"
    And question with statement "statement test" doesn't exist
    When I write a new question with statement "statement test", answer "answer test"
    Then The response code is 401
    And It has not been created a question with statement "statement test"

  Scenario: Add a new question without login
    Given I'm not logged in
    And question with statement "statement test" doesn't exist
    When I write a new question with statement "statement test", answer "answer test"
    Then The response code is 401
    And It has not been created a question with statement "statement test"

  Scenario: Add a new question as teacher with an existing statement
    Given I login as "teacher" with password "password" and role "teacher"
    And question with statement "statement test" exists
    When I write a new question with statement "statement test", answer "answer test" and level "level test" and topic "topic test"
    Then The response code is 403
    And It has not been created a question with statement "statement test"

  Scenario: Add a question as teacher with empty statement
    Given I login as "teacher" with password "password" and role "teacher"
    And question with statement "statement test" doesn't exist
    When I write a new question with statement "", answer "answer test" and level "level test" and topic "topic test"
    Then The response code is 400
    And It has not been created a question with statement ""

  Scenario: Add a question as teacher with empty answer
    Given I login as "teacher" with password "password" and role "teacher"
    And question with statement "statement test" doesn't exist
    When I write a new question with statement "statement test", answer "" and level "level test" and topic "topic test"
    Then The response code is 400
    And It has not been created a question with statement "statement test"
