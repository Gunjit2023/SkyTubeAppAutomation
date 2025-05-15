Feature: Validate Preferences Module

  Background: Launching of the app
    Given User is on homepage
    When User clicks on more options
    When User clicks on preferences button

  Scenario: Validate preferences menubar
    Then Preferences menubar appears

  Scenario Outline: Validate video player button
    When User clicks on "<testcase>" button
    Then User navigates to video player page

    Examples: 
      | testcase     |
      | videoPlayer  |
      | sponsorBlock |
      | import       |
      | privacy      |
      | network      |
      | others       |
      | about        |
