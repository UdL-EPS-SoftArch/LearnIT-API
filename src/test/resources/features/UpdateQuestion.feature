Feature: Update a question
  In order to use the app
  As a teacher
  I want to Update an existing question
  Scenario: Update question answer as teacher
    Given There is a created question with statement "statement" and answer "answer"
    And  I login as "teacher" with password "teacherpassword"
    When I change the question answer that have statement "statement" to "answer2"
    Then The response code is 200
    And it has been changed question answer with statement "statement" and new answer "answer2"


  Scenario: Update question answer as student
    Given There is a created question with statement "statement" and answer "answer"
    And I login as "student" with password "studentpassword"
    When I change the question answer that have statement "statement" to "answer2"
    Then The response code is 403
    And And I cannot update question with statement "statement"


  Scenario: Update question answer  without login
    Given There is a created question with statement "statement" and answer "answer"
    And I'm not logged in
    When I change the question answer that have statement "statement" to "answer2"
    Then The response code is 401
    And And I cannot update question with statement "statement"


  Scenario: Update question answer for non existing question as teacher
    Given There is no question with statement "statement" and answer "answer"
    And I login as "teacher" with password "teacherpassword"
    When I change the question answer that have statement "statement" to "answer2"
    Then The response code is 404


  Scenario: Update question statement as teacher
    Given There is a created question with statement "statement" and answer "answer"
    And  I login as "teacher" with password "teacherpassword"
    When I change the question statement that have statement "statement" to "statement1"
    Then The response code is 200


  Scenario: Update question statement as student
    Given There is a created question with statement "statement" and answer "answer"
    And I login as "student" with password "studentpassword"
    When I change the question statement that have statement "statement" to "statement1"
    Then The response code is 403
    And And I cannot update question with statement "statement"


  Scenario: Update question statement  without login
    Given There is a created question with statement "statement" and answer "answer"
    And I'm not logged in
    When I change the question statement that have statement "statement" to "statement1"
    Then The response code is 401
    And And I cannot update question with statement "statement"

  Scenario: Update question statement for non existing question as teacher
    Given There is no question with statement "statement" and answer "answer"
    And I login as "teacher" with password "teacherpassword"
    When I change the question statement that have statement "statement" to "statement1"
    Then The response code is 404


