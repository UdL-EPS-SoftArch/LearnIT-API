Feature: Delete a question
  In order to use the app
  As a teacher
  I want to delete an existing question


  Scenario: Delete a question as teacher
    Given There is a created question with statement "statement" and answer "answer"
    And I login as "teacher" with password "teacherpassword"
    When I delete the question with statement "statement"
    Then The response code is 204
    And It has been deleted the question with statement "statement"

  Scenario: Delete a question as student
    Given  There is a created question with statement "statement" and answer "answer"
    And I login as "student" with password "studentpassword"
    When I delete the question with statement "statement"
    Then The response code is 403
    And And I cannot delete question with statement "statement"

  Scenario: Delete a question without login
    Given There is a created question with statement "statement" and answer "answer"
    And I'm not logged in
    When I delete the question with statement "statement"
    Then The response code is 401
    And And I cannot delete question with statement "statement"


  Scenario: Delete a not existing question as teacher
    Given There is no question with statement "statement"
    And I login as "teacher" with password "teacherpassword"
    When I delete the question with statement "statement"
    Then The response code is 404


