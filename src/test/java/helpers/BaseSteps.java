package helpers;

import io.appium.java_client.android.AndroidDriver;
import pageObject.CommonLocators;

public class BaseSteps {
    protected AndroidDriver driver;
    protected DriverHelper driverHelper;

    public BaseSteps() {
        initDriver();
    }

    public void initDriver() {
        if (Hooks.driver == null) {
            throw new IllegalStateException("Hooks.driver is still null.");
        }
        this.driver = Hooks.driver;
        this.driverHelper = new DriverHelper(driver);
    }

    protected void waitForAppLaunchAndDismissPopup() {
        initDriver();
        driverHelper.clickIfVisible(CommonLocators.APP_UPDATE_VERSION_POPUP, 5);
    }

//    public BaseSteps() {
//        this.driver = Hooks.driver;
//        // assign after Hooks initializes it
//        this.driverHelper = new DriverHelper(driver);
//        if (driver == null) {
//            System.out.println("Driver is NULL in BaseSteps constructor!");
//        } else {
//            System.out.println("Driver is initialized: " + driver.getSessionId());
//        }
//
//    }


//    protected void waitForAppLaunchAndDismissPopup() {
//        assert driver != null : "Driver is not initialized.";
//        driverHelper.clickIfVisible(CommonLocators.APP_UPDATE_VERSION_POPUP, 5);
//    }

}
