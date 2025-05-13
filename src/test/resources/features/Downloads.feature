Feature: Download functionality




Scenario: Downloaded video should be present under download tab

Given: the skytube app is launched
When user enters "chuchutv\n" and select Download option of the video 
Then selected video "chuchutv\n" should be present under download tab

Scenario: deleted video should be deleted from download tab

Given the skytube app is launched and user enters "chuchutv\n" and select download option of the video 
When user delete the selected video from the download tab
Then the video should no longer be visible in the download tab

Scenario: Download tab is empty when no videos are downloaded

Given the skytube app is launched
When user opens the download tab
Then a text message "Download some videos to find them here." should be displayed

#Scenario: Toast message Downloading Should be displayed after clicking on download

#Given the skytube app is launched
#When user enters "chuchutv\n" and select download
#Then Downlading toast msg  should be displayed

#Scenario: Toast message DownloadedS Should be displayed after clicking on download

#Given the skytube app is launched
#When user enters "chuchutv\n" and select download
#Then downloaded toast msg  should be displayed

#Scenario: Toast message Could not download Should be displayed if video is not downloaded

#Given the skytube app is launched
#When user enters "chuchutv\n" and select download
#Then Could not download toast msg  should be displayed


