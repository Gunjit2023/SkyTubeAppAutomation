package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import utils.LoggerUtil;
import utils.Properties.AppConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

public class Hooks {
    public static AndroidDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(Hooks.class);



    @Before
    public void setUp(Scenario scenario) throws Exception {
        logger.info("Starting Scenario: {}", scenario.getName());
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/config.properties"));
        String relativePath = properties.getProperty("app.path");
        String appPath = new File(relativePath).getAbsolutePath();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Pixel6_LambdaTestAppiumSeries");
        options.setAutomationName("UiAutomator2");
        options.setApp(appPath);
        options.setAppWaitActivity("*");
        options.setNoReset(true);

        logger.info("📱 Initializing AndroidDriver with Appium...");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        logger.info("✅ AndroidDriver session started");

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture screenshot if the scenario fails
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {
                File destFile = new File("screenshots/" + scenario.getName() + ".png");
                boolean isRenamed = screenshot.renameTo(destFile); // Checks if renaming succeeded
                if (!isRenamed) {
                    logger.error("Failed to save screenshot: Could not rename file.");
                } else {
                    logger.info("Screenshot taken for failed scenario: {}", scenario.getName());
                }
            } catch (Exception e) {
                logger.error("Failed to save screenshot: {}", e.getMessage());
            }
        }
        logger.info("Finished Scenario: {}", scenario.getName());
        logger.info("Scenario Status: {}", scenario.getStatus());

        if (driver != null) {
            logger.info("Quitting AndroidDriver session...");
            driver.quit();
            logger.info("AndroidDriver session closed");

        }
    }

    // Log before each step
    @BeforeStep
    public void beforeStep(Scenario scenario) {
        logger.info("Starting Step: {}", scenario.getName());
    }

    // Log after each step
    @AfterStep
    public void afterStep(Scenario scenario) {
        logger.info("Finished Step: {}", scenario.getName());
    }
}
