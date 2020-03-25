Feature: Level Placement after evaluation test
  After the student has completed an evaluation test and the score is calculated the student is placed into the level

  Scenario: Student with score is placed into the level
    Given Student with username "Username" has completed an evaluation test with score "Score"
    Then Student with score "Score" has been sorted into level "Level" according to the table
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





