Feature: Search functionality in SkyTube app

  Scenario: Search for an existing channel by name
    Given the app is launched
    When the user enters "CoComelon" in the search bar
    Then the channel "CoComelon" should appear in the results

  Scenario: Search for a non-existing channel
    Given the app is launched
    When the user enters "UnknownChannelXYZ123456" in the search bar
    Then no results should be displayed
#
  Scenario: Search with special characters
    Given the app is launched
    When the user enters "@#$%^&*" in the search bar
    Then no results should be displayed
