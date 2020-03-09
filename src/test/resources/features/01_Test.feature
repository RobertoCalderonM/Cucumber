Feature: Test 01 Feature

  @tagTest1
  Scenario: Test Scenario 1
    When User profile:
    | First Name | Bob          |
    | Last Name  | Sponge       |

    When User navigates to "http://www.amazon.com"
    When User navigates to "http://www.google.com"
    When User says "I'm happy!" and sleeps
    When User says "Hello!" and sleeps
    When User says "Bye!" and sleeps