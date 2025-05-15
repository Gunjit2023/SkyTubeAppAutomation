Feature: Validate Video blocker module

  Background: Launching of the app
    Given User is on homepage
    When User clicks the video blocker

  Scenario: Validate video blocker popup closing function
    When User cancel the video blocker popup
    Then User lands on homepage

  Scenario: Validate video blocker popup setup function
    When User clicks on setup button of the video blocker popup
    Then User lands on preferences page
