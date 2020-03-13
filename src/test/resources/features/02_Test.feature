Feature: Test 02 Feature

  @tagTest2
  Scenario: Test Scenario 2
    When User profile:
      | First Name | Marco          |
      | Last Name  | Potter         |

    When User says "Hello!" and sleeps 3000 milliseconds
    When User says "Hi!" and sleeps 3000 milliseconds
    When User navigates to "http://www.google.com"
    When User navigates to "http://www.amazon.com"
