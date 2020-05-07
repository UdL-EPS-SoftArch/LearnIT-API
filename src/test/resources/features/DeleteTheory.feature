Feature: Delete a theory
  In order to use the app
  As a teacher
  I want to delete an existing theory


  Scenario: Delete a theory as teacher
    Given There is a created theory with name "theory"
    And I login as "teacher" with password "teacherpassword"
    When I delete the theory with name "theory"
    Then The response code is 204
    And It has been deleted the theory with name "theory"

  Scenario: Delete a theory as student
    Given There is a created theory with name "theory"
    And I login as "student" with password "studentpassword"
    When I delete the theory with name "theory"
    Then The response code is 403
    And And I cannot delete theory with name "theory"

  Scenario: Delete a theory without login
    Given There is a created theory with name "theory"
    And I'm not logged in
    When I delete the theory with name "theory"
    Then The response code is 401
    And And I cannot delete theory with name "theory"


  Scenario: Delete a not existing theory as teacher
    Given There is no theory with name "theory"
    And I login as "teacher" with password "teacherpassword"
    When I delete the theory with name "theory"
    Then The response code is 404


