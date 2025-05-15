package stepDefinitions;

import org.testng.Assert;

import helpers.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.VideoBlockerPage;

public class VideoBlockerSteps extends BaseSteps {
	private BaseSteps baseSteps;
	private VideoBlockerPage videoBlockerPage;

	@Given("User is on homepage")
	public void user_is_on_homepage() {
		System.out.println("I am in video blocker page");
		initDriver();  
		videoBlockerPage = new VideoBlockerPage(driver);
		waitForAppLaunchAndDismissPopup();
	}

	@When("User clicks the video blocker")
	public void user_clicks_the_video_blocker() {
		videoBlockerPage.clickOnVideoBlocker();

	}

	@When("User clicks on setup button of the video blocker popup")
	public void user_clicks_on_setup_button_of_the_video_blocker_popup() {
		videoBlockerPage.clickOnSetUp();
		videoBlockerPage.clickOndontAllow();
	}

	@Then("User lands on preferences page")
	public void user_lands_on_preferences_page() {
		Assert.assertEquals(videoBlockerPage.getTextOfPreference(), "Preferences");
	}

	@When("User cancel the video blocker popup")
	public void user_cancel_the_video_blocker_popup() {
		videoBlockerPage.clickOnCancel();
	}

	@Then("User lands on homepage")
	public void user_lands_on_homepage() {
		Assert.assertEquals(videoBlockerPage.getTextOfSkytube(), "SkyTube");
	}

	@When("User clicks on more options")
	public void user_clicks_on_more_options() {
		videoBlockerPage.clickOnMoreOptions();
	}

	@When("User clicks on watched video cleaner button")
	public void user_clicks_on_watched_video_cleaner_button() {
		videoBlockerPage.clickOnWatchedVideoCleaner();
	}

	@When("User clicks on cancel button of watched video cleaner popup")
	public void user_clicks_on_cancel_button_of__watched_video_cleaner_popup() {
		videoBlockerPage.clickOnCancel();
	}

	@Then("Watched video cleaner popup appears")
	public void watched_video_cleaner_popup_appears() {
		Assert.assertEquals(videoBlockerPage.getTextOfWatchedVideo(), "Watched Video Cleaner");
	}

	@When("User clicks on clean button of watched video cleaner popup")
	public void user_clicks_on_clean_button_of_watched_video_cleaner_popup() {
		videoBlockerPage.clickOnClean();
	}

	@Then("User can see confirm message")
	public void user_can_see_confirm_message() {
		videoBlockerPage.getToast();
	}

	@Then("Preferences menubar appears")
	public void preferences_menubar_appears() {
		Assert.assertEquals(videoBlockerPage.getTextOfPreference(), "Preferences");
	}

	@When("User clicks on preferences button")
	public void user_clicks_on_preferences_button() {
		videoBlockerPage.clickOnPreferences();
		videoBlockerPage.clickOndontAllow();
	}

	@When("User clicks on {string} button")
	public void user_clicks_on_testcase_button(String testcase) {
		videoBlockerPage.preferencesTabs(testcase);
	}

	@Then("User navigates to video player page")
	public void user_navigates_to_video_player_page() {
		Assert.assertEquals(videoBlockerPage.preferncesText(), videoBlockerPage.preferncesExpectedText());
	}
}
