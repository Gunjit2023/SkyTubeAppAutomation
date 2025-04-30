package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import helpers.BaseSteps;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SubscribeUnsubscribeChannel extends BaseSteps {

    SearchChannelModule searchChannel = new SearchChannelModule();

    public By optionsButton = By.id("free.rm.skytube.oss:id/options_button");
    public By channelLink = By.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Channel...\"]");
    public By channelArrow = By.id("free.rm.skytube.oss:id/submenuarrow");
    public By subscribeLinkId = By.id("free.rm.skytube.oss:id/channel_subscribe_button");
    public By subscribeLink = By.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Subscribe\"]");
    public By unsubscribeLink = By.xpath("//android.widget.TextView[@resource-id=\"free.rm.skytube.oss:id/title\" and @text=\"Unsubscribe\"]");
    public By backArrow = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    public By channelName = By.id("free.rm.skytube.oss:id/sub_channel_name_text_view");

    public void unsubscribe_from_channel() {
        driverHelper.clickIfVisible(optionsButton, 5);
        driverHelper.clickIfVisible(channelArrow, 5);
        driverHelper.clickIfVisible(unsubscribeLink, 5);
        boolean isToastVisible = driverHelper.waitForToastMessage("Unsubscribed", 10);
        Assert.assertTrue(isToastVisible, "Unsubscribed");
    }

    public void change_subscribed_to_unsubscribed() {
        driverHelper.clickIfVisible(optionsButton, 5);
        driverHelper.clickIfVisible(channelArrow, 5);
        driverHelper.isElementVisible(unsubscribeLink, 5);
    }

    public void unsubscribe_to_subscribe() {
        driverHelper.clickIfVisible(optionsButton, 5);
        driverHelper.clickIfVisible(channelArrow, 5);
        driverHelper.isElementVisible(subscribeLink, 5);
        assertTrue(driver.findElement(subscribeLink).isDisplayed(), "Subscribe button not shown after unsubscribe.");

    }

    public void the_user_taps_subscribe(String channelName) {
        driverHelper.clickIfVisible(optionsButton, 5);
        driverHelper.clickIfVisible(channelArrow, 5);
        driverHelper.clickIfVisible(subscribeLink, 5);

    }

    public void subscribe_last_channel() {
        driverHelper.scrollToLastVisibleChannel();
        // Locate the last visible channel's "Subscribe" button
        List<WebElement> optionsButtons = driver.findElements(optionsButton);

        if (optionsButtons.isEmpty()) {
            throw new NoSuchElementException("No subscribe buttons found on the page.");
        }

        // Click the last one
        WebElement lastoptionButton = optionsButtons.get(optionsButtons.size() - 1);
        lastoptionButton.click();
        driverHelper.clickIfVisible(channelArrow, 5);
        driverHelper.clickIfVisible(subscribeLink, 5);
    }

    public void search_subscribed_channel(){
        driverHelper.clickIfVisible(backArrow, 5);
        driverHelper.clickIfVisible(searchChannel.skyTubeHamburger, 5);
    }

    public void verify_channel_visible_in_search_channel(){
        driverHelper.isElementVisible(channelName,5);
        assertTrue(driver.findElement(channelName).isDisplayed(), "Subscribed Channel is visible in searched channel list");
    }

    public void clicks_the_unsubscribe_button(){
        driverHelper.clickIfVisible(channelName,5);
        driverHelper.clickIfVisible(subscribeLinkId,5);
    }

    public void unsubscribed_channel_not_appear_in_the_search_results(){
        driverHelper.clickIfVisible(backArrow, 5);
        driverHelper.clickIfVisible(searchChannel.skyTubeHamburger, 5);
        List<WebElement> elements = driver.findElements(channelName);
        assertTrue(elements.isEmpty(), "Unsubscribed channel is still shown in search result!");
    }

    public void user_not_subscribed_to_channel(String channelName){
        driverHelper.clickIfVisible(optionsButton, 5);
        driverHelper.clickIfVisible(channelArrow, 5);
        assertTrue(driver.findElement(subscribeLink).isDisplayed(), "Subscribe button not shown after unsubscribe.");
    }
}
