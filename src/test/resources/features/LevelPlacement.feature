Feature: Level Placement after evaluation test
  After the student has completed an evaluation test and the score is calculated the student is placed into the level

  Scenario: Student with score "Score" is placed into the level "Level"
    Given Student has completed an evaluation test
    And The score has been calculated
    Then Student has been sorted into level "Level" according to score "Score"
      | Score | Level |
      | 10    | 1     |
      | 20    | 2     |
      | 30    | 3     |
      | 40    | 4     |
      | 50    | 5     |
      | 60    | 6     |
      | 70    | 7     |
      | 80    | 8     |
      | 90    | 9     |
      | 100   | 10    |





