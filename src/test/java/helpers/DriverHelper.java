package helpers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Map;

public class DriverHelper {
    private AndroidDriver driver;

    public DriverHelper(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean clickIfVisible(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            return true;
        } catch (Exception e) {
            System.out.println("Element not clickable: " + locator);
            return false;
        }
    }

    public WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element not found: " + locator);
            return null;
        }
    }

    public boolean isElementVisible(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForToastMessage(String expectedToastText, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            return wait.until(driver -> driver.getPageSource().contains(expectedToastText));
        } catch (Exception e) {
            System.out.println("Toast message not found: " + expectedToastText);
            return false;
        }
    }

    public void scrollToLastVisibleChannel() {
        // Scroll until we reach the bottom
        while (true) {
            boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "mobile: scrollGesture",
                    Map.of(
                            "left", 100, "top", 100, "width", 800, "height", 1500,
                            "direction", "down",
                            "percent", 0.85
                    )
            );
            if (!canScrollMore) break;
        }
    }
}
