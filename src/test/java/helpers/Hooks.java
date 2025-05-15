package helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;

import utils.Properties.AppConfig;
import utils.ExcelReader;
import utils.LoggerUtil;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Hooks {
    public static AndroidDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(Hooks.class);
    public AppiumDriverLocalService service;
    static AppConfig reader = new AppConfig();
	public static Map<String, Map<String, String>> testCaseDataMap = new HashMap<>();



    @Before
    public void setUp(Scenario scenario) throws Throwable {
    	
        logger.info("Starting Scenario: {}", scenario.getName());
        AppConfig.loadConfig();
        String appPath = AppConfig.getAppPath();
        
		service =  new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\s_bor\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.1.183").usingPort(4723).build();
		service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Pixel6_LambdaTestAppiumSeries");
        options.setAutomationName("UiAutomator2");
        options.setApp(appPath);
        options.setAppWaitActivity("*");
        options.setNoReset(false);
        options.setNewCommandTimeout(Duration.ofSeconds(500));

        logger.info("📱 Initializing AndroidDriver with Appium...");
        driver = new AndroidDriver(new URI("http://192.168.1.183:4723/").toURL(), options);
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
    
    @After
    public void closeService() {
        service.stop();
    }

    //Load all test cases for all Preferences combinations
    @Before
    public void loadTestCases() throws Throwable {
    	AppConfig.loadConfig();
		ExcelReader excelReader = new ExcelReader(AppConfig.getExcelPath(), "Preferences");
		testCaseDataMap = excelReader.readAllTestCases(); 
		System.out.println("Login test cases loaded successfully!" + testCaseDataMap.keySet());
	}
}
