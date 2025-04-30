package helpers;

import io.appium.java_client.android.AndroidDriver;
import pageObject.CommonLocators;

public class BaseSteps {
    protected AndroidDriver driver = Hooks.driver;
    protected DriverHelper driverHelper = new DriverHelper(driver);


    protected void waitForAppLaunchAndDismissPopup() {
        assert driver != null : "Driver is not initialized.";
        driverHelper.clickIfVisible(CommonLocators.APP_UPDATE_VERSION_POPUP, 5);
    }

}
