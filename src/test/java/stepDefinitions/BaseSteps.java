package stepDefinitions;

import helpers.DriverHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.CommonLocators;
import java.time.Duration;

public class BaseSteps {
    protected AndroidDriver driver = Hooks.driver;
    protected DriverHelper driverHelper = new DriverHelper(driver);


    protected void waitForAppLaunchAndDismissPopup() {
        assert driver != null : "Driver is not initialized.";
        driverHelper.clickIfVisible(CommonLocators.APP_UPDATE_VERSION_POPUP, 5);
    }

}
