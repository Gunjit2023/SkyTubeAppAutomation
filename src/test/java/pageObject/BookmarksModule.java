package pageObject;

import io.appium.java_client.AppiumBy;
import helpers.BaseSteps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BookmarksModule extends BaseSteps{
	
	//Bookmnarked scenario
	public By NameOfVideo = AppiumBy.androidUIAutomator("new UiSelector().text(\"ChuChu TV Learning English Is Fun™ | Alphabet N Song | Phonics & Words For Preschool Children\")");
	public By dotOption = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"free.rm.skytube.oss:id/options_button\").instance(0)");
	public By selectBookmark=AppiumBy.androidUIAutomator("new UiSelector().text(\"Bookmark\")");
	public By GoBack=AppiumBy.accessibilityId("Navigate up");
	public By BookmarkTab=AppiumBy.androidUIAutomator("new UiSelector().text(\"BOOKMARKS\")");
	
	public By bookmarkedVideo=AppiumBy.id("free.rm.skytube.oss:id/title_text_view");
	public By searchText1 = By.id("free.rm.skytube.oss:id/search_src_text");
    public By searchIcon1 = AppiumBy.accessibilityId("Search Videos");
    
     //Unbookmarked scenario
    public By dotOptionToUnbookmark=AppiumBy.id("free.rm.skytube.oss:id/options_button");
    public By UnbbokmarkVideo=AppiumBy.androidUIAutomator("new UiSelector().text(\"Unbookmark\")");
    
    public By SecondVideoName=AppiumBy.androidUIAutomator("new UiSelector().text(\"ChuChu TV Classics - Head, Shoulders, Knees & Toes Exercise Song + More Popular Baby Nursery Rhymes\")");
	public By bookmarkSecondVideo=AppiumBy.androidUIAutomator("new UiSelector().text(\"Bookmark\")");
	public By SecondVideoDotOption=AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"free.rm.skytube.oss:id/options_button\").instance(1)");
	
	//Initially bookmark tab is emplty
	public By message=AppiumBy.id("free.rm.skytube.oss:id/noBookmarkedVideosText");
	
	
	public void bookmark_video(String string2)
	{
		driverHelper.clickIfVisible(searchIcon1, 5);
		driverHelper.clickIfVisible(searchText1, 5);
		driver.findElement(searchText1).sendKeys(string2);
		
		driverHelper.clickIfVisible(dotOption, 5);
		driverHelper.clickIfVisible(selectBookmark, 5);
		
		WebElement toast = new WebDriverWait(driver, Duration.ofSeconds(3))
			    .until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("//android.widget.Toast[contains(@text,'Bookmarked')]")
			    ));
		Assert.assertTrue(toast.getText().contains("Bookmarked"));

		
		driverHelper.clickIfVisible(GoBack, 5);
		driverHelper.clickIfVisible(BookmarkTab, 5);
	}
	
	public void unbookmark_video()
	{
		 driverHelper.clickIfVisible(dotOptionToUnbookmark, 5);
		 driverHelper.clickIfVisible(UnbbokmarkVideo, 5);
		 WebElement toast = new WebDriverWait(driver, Duration.ofSeconds(3))
				    .until(ExpectedConditions.presenceOfElementLocated(
				        By.xpath("//android.widget.Toast[contains(@text,'Bookmark removed')]")
				    ));
			Assert.assertTrue(toast.getText().contains("Bookmark removed"));
	}
}