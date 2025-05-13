package pageObject;

import io.appium.java_client.AppiumBy;
import helpers.BaseSteps;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class DownloadsModule extends BaseSteps{
	
	String expectedTitleOfVideo;
	
	public By searchText1 = By.id("free.rm.skytube.oss:id/search_src_text");
    public By searchIcon1 = AppiumBy.accessibilityId("Search Videos");
    public By NameOfDownloadVideo=AppiumBy.androidUIAutomator("new UiSelector().text(\"ChuChu TV Learning English Is Fun™ | Alphabet N Song | Phonics & Words For Preschool Children\")");
    public By downloadVideoDotOption=AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"free.rm.skytube.oss:id/options_button\").instance(0)");;
    public By selectDownload=AppiumBy.androidUIAutomator("new UiSelector().text(\"Download\")");
    public By emptyDownloadTabMsg=By.id("free.rm.skytube.oss:id/noDownloadedVideosText");
    
   // public By NavigateUp=
    public By GoBack=AppiumBy.accessibilityId("Navigate up");
    public By DownloadTab=AppiumBy.accessibilityId("Downloads");
    
    public By AccessMessage=By.id("com.android.permissioncontroller:id/permission_allow_button");
    public By MediaAccessMessage=By.id("com.android.permissioncontroller:id/permission_allow_button");
    
    public By DownloadedVideo=AppiumBy.id("free.rm.skytube.oss:id/title_text_view");
    public By DownloadedvideoDotOption=By.id("free.rm.skytube.oss:id/options_button");	
    public By DeleteDownloadOption=AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete Download\")");
    		
    
    public void download_video(String string2) 
	{
		driverHelper.clickIfVisible(searchIcon1, 5);
		driverHelper.clickIfVisible(searchText1, 5);
		driver.findElement(searchText1).sendKeys(string2);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
		    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"free.rm.skytube.oss:id/options_button\").instance(0)")
		));
		driverHelper.clickIfVisible(downloadVideoDotOption, 10);
		driverHelper.clickIfVisible(selectDownload, 5);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement allowButton = wait1.until(ExpectedConditions.elementToBeClickable(
		    By.id("com.android.permissioncontroller:id/permission_allow_button")
		));
		driverHelper.clickIfVisible(AccessMessage, 5);
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement allowButton1 = wait.until(
		    ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button"))
		);
		driverHelper.clickIfVisible(MediaAccessMessage, 5);
		
		WebElement videotitle=driverHelper.waitForElementVisible(NameOfDownloadVideo, 5);
		String name=videotitle.getText();
	
		driverHelper.clickIfVisible(GoBack, 5);
		driverHelper.clickIfVisible(DownloadTab, 5);
		
		driverHelper.waitForElementVisible(DownloadedVideo, 5);
	}

  public void deleteDownloadedVideo()
  {
	  
	  driverHelper.clickIfVisible(DownloadedvideoDotOption, 10);
	  driverHelper.clickIfVisible(DeleteDownloadOption, 10);
  }
   
}