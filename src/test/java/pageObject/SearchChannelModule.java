package pageObject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;
import helpers.BaseSteps;

import static org.testng.Assert.assertTrue;

public class SearchChannelModule extends BaseSteps {
        public By skyTubeHamburger = AppiumBy.accessibilityId("SkyTube");
        public By menuSearch = By.id("free.rm.skytube.oss:id/menu_search");
        public By searchText = By.id("free.rm.skytube.oss:id/search_src_text");


    public void launch_app(){
        waitForAppLaunchAndDismissPopup();
        driverHelper.isElementVisible(skyTubeHamburger, 5);
    }
        public void the_user_searched_for(String channelName){
        driverHelper.clickIfVisible(menuSearch, 5);
        driver.findElement(searchText).sendKeys(channelName + "\n");
        try {
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        } catch (Exception e) {
            System.out.println("ENTER key press failed, trying alternative.");
        }
    }

    public void verifyChannelVisible(String channelName){
        boolean isFound = !driver.findElements(By.xpath("//*[contains(@text,'" + channelName + "')]")).isEmpty();
        assertTrue(isFound, "Channel " + channelName + " not found.");
    }

    public void channelNotVisible(){
        boolean isToastVisible = driverHelper.waitForToastMessage("Try different keywords", 10);
        Assert.assertTrue(isToastVisible, "Error toast message is not displayed!");
    }
 }

