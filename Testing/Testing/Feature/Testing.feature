Feature: Page Testing
  Scenario: Test Home Page
    Given User is on Home Page
    When Log in
    Then Test the home page
    And Close Chrome
    
   Scenario: Test Second Page
    Given User is on Home Page
    When Log in
    And Click on Metals and Color page
    Then Test the second page
    And Close Chrome
    
    Scenario: Test Third Page
    Given User is on Home Page
    When Log in
    And Click on different page
    Then Test the third page
    And Close Chrome