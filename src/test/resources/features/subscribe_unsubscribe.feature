Feature: Subscribe and Unsubscribe from channels in SkyTube app

  Scenario: Subscribe to a channel from search results
    Given the app is launched
    When the user enters "CoComelon" in the search bar
    Then the channel "CoComelon" should appear in the results
    When the user taps the Subscribe button next to "CoComelon" channel
    Then the Subscribe button should change to Unsubscribe

  Scenario: Unsubscribe from a channel
    Given the app is launched
    And the user is subscribed to "Cocomelon"
    When the user taps the Unsubscribe button on the channel page
    Then the button should change back to Subscribe

  Scenario: Attempt to unsubscribe from a non-subscribed channel
    Given the user is not subscribed to channel "BBC News"
    When the user views the channel page for "BBC News"
    Then the Subscribe button for the channel "BBC News" should be visible

  Scenario: Attempt to subscribe to last channel on search page
    Given the app is launched
    When the user enters "CoComelon" in the search bar
    Then the channel "CoComelon" should appear in the results
    And the user scrolls down search page and subscribe to last channel
    When the user searches for the subscribed channel
    Then the subscribed channel should appear in the search results
    When the user clicks the unsubscribe button next to the channel
    Then the channel should no longer appear in the search results
