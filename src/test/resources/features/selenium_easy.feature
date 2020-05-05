@selenium-easy
Feature: Sample Test

  Background: Navigate to Page
    Given I open the "chrome" browser

  Scenario: Form Submit
    When I access the Selenium Easy page
    And I move to the Simple Form Demo page
    And I submit the message "This is a test" in the form
    Then The message "This is a test" should be displayed correctly
