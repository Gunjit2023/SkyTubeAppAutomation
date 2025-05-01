package stepDefinitions;

import helpers.BaseSteps;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import pageObject.SearchChannelModule;
import pageObject.SubscribeUnsubscribeChannel;
import utils.LoggerUtil;

public class SubscribeUnsubscribeChannelSteps extends BaseSteps {

    private static final Logger logger = LoggerUtil.getLogger(SubscribeUnsubscribeChannelSteps.class);
    private final SubscribeUnsubscribeChannel subscribeUnsubscribeChannel;
    private final SearchChannelModule searchChannelModule;

    public SubscribeUnsubscribeChannelSteps() {
        super(); // initializes 'driver' from Hooks
        this.searchChannelModule = new SearchChannelModule(driver);
        this.subscribeUnsubscribeChannel = new SubscribeUnsubscribeChannel(driver);
    }


    @Step("the user is not subscribed to channel {string}")
    @And("the user is not subscribed to channel {string}")
    public void the_user_is_not_subscribed_to_channel(String channelName) {
        searchChannelModule.the_user_searched_for(channelName);
    }

    @Step("the user views the channel page for {string}")
    @When("the user views the channel page for {string}")
    public void the_user_views_the_channel_page(String channelName) {
        searchChannelModule.verifyChannelVisible(channelName);
    }

    @Step("the Subscribe button for the channel {string} should be visible")
    @Then("the Subscribe button for the channel {string} should be visible")
    public void the_subscribe_button_is_visible(String channelName) {
        subscribeUnsubscribeChannel.user_not_subscribed_to_channel(channelName);
    }


    @Step("User should see subscribe to channel button  {string} in results")
    @When("the user taps the Subscribe button next to {string} channel")
    public void the_user_taps_the_subscribe_button_next_to_channel(String channelName) {
        subscribeUnsubscribeChannel.the_user_taps_subscribe(channelName);
    }

    @Step("Then the subscribe button should change to unsubscribe")
    @Then("the Subscribe button should change to Unsubscribe")
    public void the_subscribe_button_changed_to_unsubscribe() {
        subscribeUnsubscribeChannel.change_subscribed_to_unsubscribed();
    }

    @Step("the user is subscribed to {string}")
    @And("the user is subscribed to {string}")
    public void user_is_subscribed(String channelName) {
        searchChannelModule.the_user_searched_for(channelName);
        subscribeUnsubscribeChannel.the_user_taps_subscribe(channelName);
    }

    @Step("the user taps the Unsubscribe button on the channel page")
    @When("the user taps the Unsubscribe button on the channel page")
    public void user_taps_unsubscribe() {
        subscribeUnsubscribeChannel.unsubscribe_from_channel();
    }

    @Step("the button should change back to Subscribe")
    @Then("the button should change back to Subscribe")
    public void button_changes_back_to_subscribe() {
        subscribeUnsubscribeChannel.unsubscribe_to_subscribe();
    }

    @Step("the user scrolls down search page and subscribe to last channel")
    @And("the user scrolls down search page and subscribe to last channel")
    public void subscribe_to_last_channel() {
        subscribeUnsubscribeChannel.subscribe_last_channel();
    }

    @Step("the user searches for the subscribed channel")
    @When("the user searches for the subscribed channel")
    public void user_search_subscribed_channel() {
        subscribeUnsubscribeChannel.search_subscribed_channel();
    }

    @Step("the subscribed channel should appear in the search results")
    @Then("the subscribed channel should appear in the search results")
    public void verify_channel_visibility_in_search_channel() {
        subscribeUnsubscribeChannel.verify_channel_visible_in_search_channel();
    }

    @Step("the user clicks the unsubscribe button next to the channel")
    @When("the user clicks the unsubscribe button next to the channel")
    public void user_clicks_the_unsubscribe_button_next_to_channel() {
        subscribeUnsubscribeChannel.clicks_the_unsubscribe_button();
    }

    @Step("the channel should no longer appear in the search results")
    @Then("the channel should no longer appear in the search results")
    public void channel_should_not_appear_in_the_search_results() {
        subscribeUnsubscribeChannel.unsubscribed_channel_not_appear_in_the_search_results();
    }

}

