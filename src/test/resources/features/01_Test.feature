Feature: Test 01 Feature

  @tagTest1
  Scenario: Test Scenario 1
    When User profile:
    | First Name | Bob          |
    | Last Name  | Sponge       |

    Then A Client is found with id 1
    Then A Client is found with id 2
    Then A Product is found with id 1
    Then A Product is found with name "Chocolate"
    When User navigates to "http://www.amazon.com"
    Then I say "Hi!" to Amazon!
    Then Browser is refreshed
    Then I say "Hi Again!" to Amazon!
    When User navigates to "http://www.google.com"
    Then I say "Hello!" to Google!
    When User says "I'm happy!" and sleeps 3000 milliseconds
    When User says "Hello!" and sleeps 3000 milliseconds
    When User says "Bye!" and sleeps 3000 milliseconds