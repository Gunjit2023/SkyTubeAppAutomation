Feature: Search functionality in SkyTube app

  Scenario: Search for an existing channel by name
    Given the app is launched
    When the user enters "MrBeast" in the search bar
#    Then the channel "MrBeast" should appear in the results

#  Scenario: Search for a non-existing channel
#    Given the app is launched
#    When the user enters "UnknownChannelXYZ123" in the search bar
#    Then no results should be displayed
#
#  Scenario: Search with special characters
#    Given the app is launched
#    When the user enters "@#$%^&*" in the search bar
#    Then the app should show a message "No results found"