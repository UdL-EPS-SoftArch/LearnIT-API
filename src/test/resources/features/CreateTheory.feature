Feature: Create a theory
  In order to use the app
  As a teacher
  I want to add a new theory


  Scenario: Add a new theory as teacher
    Given I login as "teacher" with password "teacherpassword"
    And theory with name "theory" doesn't exist
    When I write a new theory with name "theory", url "youtube.com" and text "text"
    Then The response code is 201
    And It has been created a theory with name "theory", url"youtube.com" and text"text"

  Scenario: Add a new theory as student
    Given I login as "student" with password "studentpassword"
    And theory with name "theory" doesn't exist
    When I write a new theory with name "theory", url "youtube.com" and text "text"
    Then The response code is 403

  Scenario: Add a new theory without login
    Given I'm not logged in
    And theory with name "theory" doesn't exist
    When I write a new theory with name "theory", url "youtube.com" and text "text"
    Then The response code is 401

  Scenario: Add a new theory as teacher with an existing name
    Given I login as "teacher" with password "teacherpassword"
    And theory with name "theory"  exist
    When I write a new theory with name "theory", url "youtube.com" and text "text"
    Then The response code is 409
    And It has not been created a theory with name "theory"

  Scenario: Add a theory as teacher with empty name
    Given I login as "teacher" with password "teacherpassword"
    And theory with name "" doesn't exist
    When I write a new theory with name "", url "youtube.com" and text "text"
    Then The response code is 400
