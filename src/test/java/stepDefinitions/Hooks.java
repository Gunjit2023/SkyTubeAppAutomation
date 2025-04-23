package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URI;
import java.net.URL;

public class Hooks {
    public static AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Pixel6_LambdaTestAppiumSeries");
        options.setAutomationName("UiAutomator2");
        options.setApp("/Users/Gurbax Gill/Downloads/free.rm.skytube.oss_55.apk");
        options.setAppWaitActivity("*");
        options.setNoReset(true);

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
