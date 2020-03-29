Feature: Create a question
  In order to use the app
  As a teacher
  I want to add a new question
  Background:
    Given There is a level
    And There is a topic


  Scenario: Add a new question as teacher
    Given I login as "teacher" with password "teacherpassword"
    And question with statement "statement" doesn't exist
    When I write a new question with statement "statement" and answer "answer"
    Then The response code is 201
    And It has been created a question with statement "statement" and answer "answer"

  Scenario: Add a new question as student
    Given I login as "student" with password "studentpassword"
    And question with statement "statement" doesn't exist
    When I write a new question with statement "statement", answer "answer"
    Then The response code is 403


  Scenario: Add a new question without login
    Given I'm not logged in
    And question with statement "statement" doesn't exist
    When I write a new question with statement "statement", answer "answer"
    Then The response code is 401


  Scenario: Add a new question as teacher with an existing statement
    Given I login as "teacher" with password "teacherpassword"
    And question with statement "statement" exists
    When I write a new question with statement "statement", answer "answer"
    Then The response code is 409
    And It has not been created a question with statement "statement"


  Scenario: Add a question as teacher with empty statement
    Given I login as "teacher" with password "teacherpassword"
    And question with statement "" doesn't exist
    When I write a new question with statement "", answer "answer"
    Then The response code is 400



  Scenario: Add a question as teacher with empty answer
    Given I login as "teacher" with password "teacherpassword"
    And question with statement "statement" doesn't exist
    When I write a new question with statement "statement", answer ""
    Then The response code is 400


  Scenario: Add a question as teacher with empty statement and answer
    Given I login as "teacher" with password "teacherpassword"
    And question with statement "" doesn't exist
    When I write a new question with statement "", answer ""
    Then The response code is 400



