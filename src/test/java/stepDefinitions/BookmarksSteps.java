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
import pageObject.SearchChannelModule;
import utils.LoggerUtil;

import static org.testng.Assert.*;

import java.time.Duration;
import java.util.List;

import helpers.BaseSteps;

public class BookmarksSteps extends BaseSteps {
	BookmarksModule bookmarkmodule=new BookmarksModule();
	private static final Logger logger = LoggerUtil.getLogger(BookmarksSteps.class);
	String expectedTitleOfVideo;
	String actualTitle;
	
	@Given("the skytube app is launched")
	public void the_skytube_app_is_launched() {
		 waitForAppLaunchAndDismissPopup();
	}

@When("user enters {string} and select bookmark option of the video")
public void user_enters_and_select_bookmark_option_of_the_video(String string1) {
	bookmarkmodule.bookmark_video(string1);
}
@Then("selected video {string} should be present under bookmark tab")
public void selected_video_should_be_present_under_bookmark_tab(String string) {
	WebElement VideoTitle = driverHelper.waitForElementVisible(bookmarkmodule.NameOfVideo, 5);
	expectedTitleOfVideo = VideoTitle.getText();
	WebElement bookmarkedVideoTitle=driverHelper.waitForElementVisible(bookmarkmodule.bookmarkedVideo, 5);
    actualTitle=bookmarkedVideoTitle.getText();
    assertEquals(expectedTitleOfVideo, actualTitle);
}
	

@Given("the skytube app is launched and user enters {string} and select bookmark option of the video")
public void the_skytube_app_is_launched_and_user_enters_and_select_bookmark_option_of_the_video(String string2) {
	waitForAppLaunchAndDismissPopup();
	bookmarkmodule.bookmark_video(string2);
}
@When("user unbookmarks the selected video from the bookmark tab")
public void user_unbookmarks_the_selected_video_from_the_bookmark_tab() {
  bookmarkmodule.unbookmark_video();
  }
@Then("the video should no longer be visible in the bookmark tab")
public void the_video_should_no_longer_be_visible_in_the_bookmark_tab() {
	 WebElement bookmarkedVideoTitle=driverHelper.waitForElementVisible(bookmarkmodule.bookmarkedVideo, 5);
	 //String actualmessage = bookmarkedVideoTitle.getText(); 
     assertNull(bookmarkedVideoTitle);
}

@When("user opens the bookmark tab")
public void user_opens_the_bookmark_tab() {
	driverHelper.clickIfVisible(bookmarkmodule.BookmarkTab, 5);
}
@Then("a message {string} should be displayed")
public void a_message_should_be_displayed(String messg) {
    WebElement textMessage=driverHelper.waitForElementVisible((bookmarkmodule.message), 5);
    String actualmessage=textMessage.getText();
    assertEquals(actualmessage, messg);
}
}