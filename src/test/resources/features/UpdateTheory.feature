Feature: Update a theory
  In order to use the app
  As a teacher
  I want to Update an existing theory
  Scenario: Update theory text as teacher
    Given There is a created theory with name "theory"
    And  I login as "teacher" with password "teacherpassword"
    When I change the theory text that have name "theory" to "text2"
    Then The response code is 200
    And it has been changed theory text with name "theory" and new text "text2"

  Scenario: Update theory text as student
    Given There is a created theory with name "theory"
    And I login as "student" with password "studentpassword"
    When I change the theory text that have name "theory" to "text2"
    Then The response code is 403
    And And I cannot update theory with name "theory"

  Scenario: Update theory text without login
    Given There is a created theory with name "theory"
    And I'm not logged in
    When I change the theory text that have name "theory" to "text2"
    Then The response code is 401
    And And I cannot update theory with name "theory"

  Scenario: Update theory text non existing theory as teacher
    Given There no theory with name "theory"
    And I login as "teacher" with password "teacherpassword"
    When I change the theory text that have name "theory" to "text2"
    Then The response code is 404


  Scenario: Update theory url as teacher
    Given There is a created theory with name "theory"
    And  I login as "teacher" with password "teacherpassword"
    When I change the theory url that have name "theory" to "dialymotion.com"
    Then The response code is 200
    

  Scenario: Update theory url as student
    Given There is a created theory with name "theory"
    And I login as "student" with password "studentpassword"
    When I change the theory url that have name "theory" to "dialymotion.com"
    Then The response code is 403
    And And I cannot update theory with name "theory"

  Scenario: Update theory url without login
    Given There is a created theory with name "theory"
    And I'm not logged in
    When  I change the theory url that have name "theory" to "dialymotion.com"
    Then The response code is 401
    And And I cannot update theory with name "theory"

  Scenario: Update theory url non existing theory as teacher
    Given There no theory with name "theory"
    And I login as "teacher" with password "teacherpassword"
    When  I change the theory url that have name "theory" to "dialymotion.com"
    Then The response code is 404

  Scenario: Update theory name as teacher
    Given There is a created theory with name "theory"
    And  I login as "teacher" with password "teacherpassword"
    When I change the theory name that have name "theory" to "theory2"
    Then The response code is 200

  Scenario: Update theory name as student
    Given There is a created theory with name "theory"
    And I login as "student" with password "studentpassword"
    When I change the theory name that have name "theory" to "theory2"
    Then The response code is 403
    And And I cannot update theory with name "theory"

  Scenario: Update theory name without login
    Given There is a created theory with name "theory"
    And I'm not logged in
    When I change the theory name that have name "theory" to "theory2"
    Then The response code is 401
    And And I cannot update theory with name "theory"

  Scenario: Update theory name non existing theory as teacher
    Given There no theory with name "theory"
    And I login as "teacher" with password "teacherpassword"
    When I change the theory name that have name "theory" to "theory2"
    Then The response code is 404




