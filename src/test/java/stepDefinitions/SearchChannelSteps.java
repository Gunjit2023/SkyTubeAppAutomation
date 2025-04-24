package stepDefinitions;

import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.SearchChannelModule;

import static org.testng.Assert.*;

public class SearchChannelSteps extends BaseSteps {
    SearchChannelModule searchChannel = new SearchChannelModule();

    @Step("User launches the app")
    @Given("the app is launched")
    public void the_app_is_launched() {
        waitForAppLaunchAndDismissPopup();
        driverHelper.clickIfVisible(searchChannel.skyTubeHamburger, 5);
    }

    @Step("User searches for {string}")
    @When("the user enters {string} in the search bar")
    public void the_user_enters_in_the_search_bar(String query) {
        driverHelper.clickIfVisible(searchChannel.searchText, 5);
//        driver.findElement(By.id("free.rm.skytube:id/menu_search")).click();
        driver.findElement(searchChannel.searchText).sendKeys(query);

    }

    @Step("User should see channel {string} in results")
    @Then("the channel {string} should appear in the results")
    public void the_channel_should_appear_in_the_results(String channelName) {
        boolean isFound = !driver.findElements(By.xpath("//*[contains(@text,'" + channelName + "')]")).isEmpty();
        assertTrue(isFound, "Channel " + channelName + " not found.");
    }
}

