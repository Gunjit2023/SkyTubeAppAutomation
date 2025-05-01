package pageObject;

import helpers.DriverHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class SearchChannelModule {

    private AndroidDriver driver;
    private DriverHelper driverHelper;

    public SearchChannelModule(AndroidDriver driver) {
        this.driver = driver;
        this.driverHelper = new DriverHelper(driver);
    }

    public By skyTubeHamburger = AppiumBy.accessibilityId("SkyTube");
    public By menuSearch = By.id("free.rm.skytube.oss:id/menu_search");
    public By searchText = By.id("free.rm.skytube.oss:id/search_src_text");
    public By channelText = By.id("free.rm.skytube.oss:id/sub_channel_name_text_view");


    public void launch_app() {
        driverHelper.clickIfVisible(By.id("free.rm.skytube.oss:id/update_button"), 5); // Optional popup dismiss
        driverHelper.isElementVisible(skyTubeHamburger, 5);
    }

    public void the_user_searched_for(String channelName) {
        driverHelper.clickIfVisible(menuSearch, 5);
        driver.findElement(searchText).sendKeys(channelName + "\n");
        try {
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        } catch (Exception e) {
            System.out.println("ENTER key press failed, trying alternative.");
        }
    }


    public void verifyChannelVisible(String channelName) {
        boolean isFound = !driver.findElements(By.xpath("//*[contains(@text,'" + channelName + "')]")).isEmpty();
        assertTrue(isFound, "Channel " + channelName + " not found.");
    }

    public void channelNotVisible() {
        boolean toastFound = driverHelper.isToastMessageDisplayed("Try different keywords", 5);
        Assert.assertTrue(toastFound, "Expected toast message was not found!");
//        boolean isToastVisible = driverHelper.waitForToastMessage("Try different keywords", 10);
//        Assert.assertTrue(isToastVisible, "Error toast message is not displayed!");
    }

    public void no_channel_results_should_be_shown() {
        List<WebElement> channels = driver.findElements(channelText);
        assertTrue(channels.isEmpty(), "Channel unexpectedly found for an unknown name!");
    }
}

