Feature: Create a question
  In order to use the app
  As a teacher
  I want to add a new question

  Scenario: Add a new question as teacher
    Given I'am login as "teacher" with password "password"
    And level "level test" and topic "topic test" exist
    And topic "topic test" is in level "level test"
    When I write a new question with statement "statement test", answer "answer test" and level "level test" and topic "topic test"
    Then The response code is 201
    And It has been created a question with statement "statement test", answer "answer test" and level "level test" and topic "top

  Scenario: Add a new question as student
    Given I'am login as "student" with password "password"
    And level "level test" and topic "topic test" exist
    And topic "topic test" is in level "level test"
    When I write a new question with statement "statement test", answer "answer test" and level "level test" and topic "topic test"
    Then The response code is 401
    And It has not been created a question with statement "statement test"

  Scenario: Add a question as teacher with empty statement
    Given I'am login as "teacher" with password "password"
    And level "level test" and topic "topic test" exist
    And topic "topic test" is in level "level test"
    When I write a new question with statement "", answer "answer test" and level "level test" and topic "topic test"
    Then The response code is 400
    And It has not been created a question with statement ""

  Scenario: Add a question as teacher with empty answer
    Given I'am login as "teacher" with password "password"
    And level "level test" and topic "topic test" exist
    And topic "topic test" is in level "level test"
    When I write a new question with statement "statement test", answer "" and level "level test" and topic "topic test"
    Then The response code is 400
    And It has not been created a question with statement "statement test"

  Scenario: Add a question as teacher with empty level
    Given I'am login as "teacher" with password "password"
    When I write a new question with statement "statement test", answer "answer test" and level "" and topic "topic test"
    Then The response code is 400
    And It has not been created a question with statement "statement test"

  Scenario: Add a question as teacher with empty topic
    Given I'am login as "teacher" with password "password"
    When I write a new question with statement "statement test", answer "answer test" and level "level test" and topic ""
    Then The response code is 400
    And It has not been created a question with statement "statement test"

  Scenario: Add a question as teacher with a no existing level
    Given I'am login as "teacher" with password "password"
    And Level "level test" doesn't exist and topic "topic test" exist
    When I write a new question with statement "statement test", answer "answer test" and level "level test" and topic "topic test"
    Then The response code is 410
    And It has not been created a question with statement "statement test"

  Scenario: Add a question as teacher with a no existing topic
    Given I'am login as "teacher" with password "password"
    And Level "level test" exist and topic "topic test" doesn't exist
    When I write a new question with statement "statement test", answer "answer test" and level "level test" and topic "topic test"
    Then The response code is 410
    And It has not been created a question with statement "statement test"

  Scenario: Add a question as teacher with a topic not into the good level
    Given I'am login as "teacher" with password "password"
    And Level "level test" don't exist and topic "topic test" exist
    And topic "topic test" is in level "level test"
    When I write a new question with statement "statement test", answer "answer test" and level "level test" and topic "topic test"
    Then The response code is 411
    And It has not been created a question with statement "statement test"