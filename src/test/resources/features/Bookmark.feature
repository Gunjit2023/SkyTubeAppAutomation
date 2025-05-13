Feature: Bookmark functionality

Scenario: Bookmark selected video should be present under bookmark tab

Given the skytube app is launched
When user enters "chuchutv\n" and select bookmark option of the video 
Then selected video "chuchutv" should be present under bookmark tab

Scenario: Unbookmark video should be deleted from bookmark tab

Given the skytube app is launched and user enters "chuchutv\n" and select bookmark option of the video 
When user unbookmarks the selected video from the bookmark tab
Then the video should no longer be visible in the bookmark tab

Scenario: Bookmark tab is empty when no videos are bookmarked

Given the skytube app is launched
When user opens the bookmark tab
Then a message "Bookmark some videos to find them here." should be displayed
