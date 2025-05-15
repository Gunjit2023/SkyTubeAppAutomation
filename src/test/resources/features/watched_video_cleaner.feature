Feature: Validate Watched Video Cleaner Module

  Background: Launching of the app
    Given User is on homepage
    When User clicks on more options
    When User clicks on watched video cleaner button

  Scenario: Validate watched video cleaner function
    Then Watched video cleaner popup appears

  Scenario: Validate watched video cleaner popup closing function
    When User clicks on cancel button of watched video cleaner popup
    Then User lands on homepage

  Scenario: Validate watched video blocker popup clean function
    When User clicks on clean button of watched video cleaner popup
    Then User can see confirm message
