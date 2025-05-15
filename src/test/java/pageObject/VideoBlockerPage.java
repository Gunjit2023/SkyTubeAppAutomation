package pageObject;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helpers.BaseSteps;
import helpers.DriverHelper;
import helpers.Hooks;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class VideoBlockerPage {
	  private AndroidDriver driver;
	    private DriverHelper driverHelper;
	 
	    public VideoBlockerPage(AndroidDriver driver) {
	        this.driver = driver;
	        this.driverHelper = new DriverHelper(driver);
	    }
	    
	public static Map<String, Map<String, String>> testCaseDataMap = new HashMap<>();
	static Map<String, String> testData;
	static String testCaseName;
	public By videoBlockerButton = AppiumBy
			.androidUIAutomator("new UiSelector().resourceId(\"free.rm.skytube.oss:id/menu_badge_icon\")");
	public By cancelButton = AppiumBy
			.androidUIAutomator("new UiSelector().resourceId(\"free.rm.skytube.oss:id/md_buttonDefaultNegative\")");
	public By closeButton = By.id("android:id/button3");
	public By setupButton = By.id("free.rm.skytube.oss:id/md_buttonDefaultPositive");
	public By dontallowButton = By.id("com.android.permissioncontroller:id/permission_deny_button");
	public By moreOptionsBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"More options\")");
	public By preferencesBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Preferences\")");
	public By videoPlayerBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Video Player\")");
	public By videoBlockerPreferencesBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Video Blocker\")");
	public By sponsorBlockBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"SponsorBlock\")");
	public By importExportBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Import/Export\")");
	public By PrivacyBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Privacy\")");
	public By networkNDownloadBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Network and Downloads\")");
	public By othersBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Others\")");
	public By AboutBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"About\")");
	public By videoPlayerText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Video Player\").instance(0)");
	public By videoBlockerPrefText = AppiumBy
			.androidUIAutomator("new UiSelector().text(\"Video Blocker\").instance(0)");
	public By sponsorBlockText = AppiumBy.androidUIAutomator("new UiSelector().text(\"SponsorBlock\")");
	public By importExportText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Import/Export\")");
	public By privacyText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Privacy\")");
	public By networkNDownloadsText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Network and Downloads\")");
	public By othersText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Others\")");
	public By aboutText = AppiumBy.androidUIAutomator("new UiSelector().text(\"About\")");
	public By watchedVideoText = By.id("free.rm.skytube.oss:id/md_title");
	public By cleanButton = By.id("free.rm.skytube.oss:id/md_buttonDefaultPositive");
	public By watchedVideoCleanerButton = AppiumBy
			.androidUIAutomator("new UiSelector().text(\"Watched Video Cleaner\")");
	public By watchedVideoCleanerPopupCancelButton = By.id("free.rm.skytube.oss:id/md_buttonDefaultNegative");
	public By watchedVideoCleanerPopupCleanButton = By.id("free.rm.skytube.oss:id/md_buttonDefaultPositive");
	public By skytubeText = AppiumBy.androidUIAutomator("new UiSelector().text(\"SkyTube\")");
	public By preferenceText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Preferences\")");

	public By toastMessage = By.xpath("(//android.widget.Toast)");

	public void closePopUp() {
		driverHelper.clickIfVisible(closeButton, 5);
	}

	public void clickOnVideoBlocker() {
		driverHelper.clickIfVisible(videoBlockerButton, 5);
	}

	public void clickOnSetUp() {
		driverHelper.clickIfVisible(setupButton, 5);
	}

	public void clickOnCancel() {
		driverHelper.clickIfVisible(cancelButton, 5);
	}

	public void clickOndontAllow() {
		driverHelper.clickIfVisible(dontallowButton, 5);
	}

	public void clickOnMoreOptions() {
		driverHelper.clickIfVisible(moreOptionsBtn, 5);
	}

	public void clickOnWatchedVideoCleaner() {
		driverHelper.clickIfVisible(watchedVideoCleanerButton, 5);
	}

	public void clickOnClean() {
		driverHelper.clickIfVisible(cleanButton, 5);
	}

	public void clickOnPreferences() {
		driverHelper.clickIfVisible(preferencesBtn, 5);
	}

	public String getTextOfSkytube() {
		String newText = driverHelper.getTextIfVisible(skytubeText, 5);
		System.out.println("text = " + newText);
		return newText;
	}

	public String getTextOfPreference() {
		String newText = driverHelper.getTextIfVisible(preferenceText, 5);
		System.out.println("text = " + newText);
		return newText;
	}

	public String getTextOfWatchedVideo() {
		String newText = driverHelper.getTextIfVisible(watchedVideoCleanerButton, 5);
		System.out.println("text = " + newText);
		return newText;
	}

	public String getConfirmMessage() {
		String confirmMessage = driverHelper.getToastMessageIfVisible(toastMessage, 5);
		System.out.println("confirmMessage = " + confirmMessage);
		return confirmMessage;
	}

	public void getToast() {
		driverHelper.isToastMessageDisplayed("null", 5);
	}

	public void preferencesTabs(String testcase) {
		testData = Hooks.testCaseDataMap.get(testcase);
		testCaseName = testData.get("TestCaseName");
		System.out.println("TestCaseName = " + testCaseName);

		switch (testCaseName) {
		case "videoPlayer":
			driverHelper.clickIfVisible(videoPlayerBtn, 15);
			break;
		case "sponsorBlock":
			driverHelper.clickIfVisible(sponsorBlockBtn, 5);
			break;
		case "import":
			driverHelper.clickIfVisible(importExportBtn, 5);
			break;
		case "privacy":
			driverHelper.clickIfVisible(PrivacyBtn, 5);
			break;
		case "network":
			driverHelper.clickIfVisible(networkNDownloadBtn, 5);
			break;
		case "others":
			driverHelper.clickIfVisible(othersBtn, 5);
			break;
		case "about":
			driverHelper.clickIfVisible(AboutBtn, 5);
			break;
		default:
			System.out.println("Invalid test case name: " + testCaseName);
			break;
		}
	}

	public String preferncesText() {
		switch (testCaseName) {
		case "videoPlayer":
			return driverHelper.getTextIfVisible(videoPlayerBtn, 15);
		case "sponsorBlock":
			return driverHelper.getTextIfVisible(sponsorBlockBtn, 5);
		case "import":
			return driverHelper.getTextIfVisible(importExportBtn, 5);
		case "privacy":
			return driverHelper.getTextIfVisible(PrivacyBtn, 5);
		case "network":
			return driverHelper.getTextIfVisible(networkNDownloadBtn, 5);
		case "others":
			return driverHelper.getTextIfVisible(othersBtn, 5);
		case "about":
			return driverHelper.getTextIfVisible(AboutBtn, 5);
		default:
			return null;
		}
	}

	/*
	 * public String preferncesExpectedText() {
	 * 
	 * if(testCaseName.equals("videoPlayer")) { return
	 * testData.get("Expected_text"); } else if(testCaseName.equals("sponsorBlock"))
	 * { return driverHelper.getTextIfVisible(sponsorBlockBtn, 5);
	 * 
	 * } else if(testCaseName.equals("import")) { return
	 * driverHelper.getTextIfVisible(importExportBtn, 5);
	 * 
	 * } else if(testCaseName.equals("privacy")) { return
	 * driverHelper.getTextIfVisible(PrivacyBtn, 5);
	 * 
	 * } else if(testCaseName.equals("network")) { return
	 * driverHelper.getTextIfVisible(networkNDownloadBtn, 5);
	 * 
	 * } else if(testCaseName.equals("others")) { return
	 * driverHelper.getTextIfVisible(othersBtn, 5);
	 * 
	 * } else if(testCaseName.equals("about")) { return
	 * driverHelper.getTextIfVisible(AboutBtn, 5); }
	 * 
	 * return null;
	 * 
	 * }
	 */

	public String preferncesExpectedText() {
		return testData.get("Expected_text");
	}
}
