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

//    public boolean waitForToastMessage(String expectedToastText, int timeoutInSeconds) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//            return wait.until(ExpectedConditions.presenceOfElementLocated(
//                    By.xpath("//android.widget.Toast[@text='" + expectedToastText + "']")
//            )) != null;
//        } catch (Exception e) {
//            System.out.println("Toast not found: " + e.getMessage());
//            return false;
//        }
//    }

    public boolean isToastMessageDisplayed(String expectedMessage, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(".//*[contains(@text,'" + expectedMessage + "')]"))) != null;
        } catch (Exception e) {
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
	public String getTextIfVisible(By locator, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			String text = element.getText();
			return text;
		} catch (Exception e) {
			System.out.println("Text not visible: " + locator);
			return "Text not visible";
		}
	}

	public String getToastMessageIfVisible(By locator, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			String text = element.getAttribute("name");
			return text;
		} catch (Exception e) {
			System.out.println("Text not visible: " + locator);
			return "Text not visible";
		}
	}

}
