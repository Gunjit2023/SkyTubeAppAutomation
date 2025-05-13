package stepDefinitions;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import lombok.Getter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.Assert;

import pageObject.BookmarksModule;
import pageObject.DownloadsModule;
import pageObject.SearchChannelModule;
import utils.LoggerUtil;

import static org.testng.Assert.*;

import java.time.Duration;
import java.util.List;
import helpers.BaseSteps;

public class DownloadsSteps extends BaseSteps {
	DownloadsModule Downloadmodule=new DownloadsModule();
	private static final Logger logger = LoggerUtil.getLogger(BookmarksSteps.class);
	String expectedTitleOfVideo;
	String actualTitle;
	
	
@When("user enters {string} and select Download option of the video")
public void user_enters_and_select_download_option_of_the_video(String string) throws InterruptedException {
	waitForAppLaunchAndDismissPopup();
	Downloadmodule.download_video(string);
}


@Then("selected video {string} should be present under download tab")
public void selected_video_should_be_present_under_download_tab(String string) {
	WebElement VideoTitle = driverHelper.waitForElementVisible(Downloadmodule.NameOfDownloadVideo, 5);
	expectedTitleOfVideo = VideoTitle.getText();
	WebElement downloadedVideoTitle=driverHelper.waitForElementVisible(Downloadmodule.DownloadedVideo, 5);
   actualTitle=downloadedVideoTitle.getText();
   assertEquals(expectedTitleOfVideo, actualTitle);
}
@Given("the skytube app is launched and user enters {string} and select download option of the video")
public void the_skytube_app_is_launched_and_user_enters_and_select_download_option_of_the_video(String string)  {
	waitForAppLaunchAndDismissPopup();
	Downloadmodule.download_video(string);
}
@When("user delete the selected video from the download tab")
public void user_delete_the_selected_video_from_the_download_tab() {
    Downloadmodule.deleteDownloadedVideo();
}
@Then("the video should no longer be visible in the download tab")
public void the_video_should_no_longer_be_visible_in_the_download_tab() {
	 WebElement downloadedVideoTitle=driverHelper.waitForElementVisible(Downloadmodule.DownloadedVideo, 5);
	 //String actualmessage = bookmarkedVideoTitle.getText(); 
     assertNull(downloadedVideoTitle);
}

@When("user opens the download tab")
public void user_opens_the_download_tab() {
	 waitForAppLaunchAndDismissPopup();
	driverHelper.clickIfVisible(Downloadmodule.DownloadTab, 5); 
}


@Then("a text message {string} should be displayed")
public void a_text_message_should_be_displayed(String textmsg) {
	WebElement msg = driverHelper.waitForElementVisible(Downloadmodule.emptyDownloadTabMsg, 5);
	String downloadMsg = msg.getText();
	assertEquals(downloadMsg, textmsg);
}



}







