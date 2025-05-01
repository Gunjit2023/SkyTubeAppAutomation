package stepDefinitions;

import helpers.BaseSteps;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import pageObject.SearchChannelModule;
import utils.LoggerUtil;

public class SearchChannelSteps extends BaseSteps {

    private static final Logger logger = LoggerUtil.getLogger(SearchChannelSteps.class);
    private SearchChannelModule searchChannel;


    @Given("the app is launched")
    public void the_app_is_launched() {
        initDriver();  // This initializes driver and driverHelper
        searchChannel = new SearchChannelModule(driver); // Safely initialize after driver is ready
        waitForAppLaunchAndDismissPopup();
    }

    @Step("User searches for {string}")
    @When("the user enters {string} in the search bar")
    public void the_user_enters_in_the_search_bar(String query) {
        searchChannel.the_user_searched_for(query);
    }

    @Step("User should see channel {string} in results")
    @Then("the channel {string} should appear in the results")
    public void the_channel_should_appear_in_the_results(String channelName) {
        searchChannel.verifyChannelVisible(channelName);
    }

    @Step("no results should be displayed")
    @Then("no results should be displayed")
    public void no_results_should_be_displayed() throws InterruptedException {
        searchChannel.channelNotVisible();
    }

    @Step("no channel result should be shown")
    @Then("no channel result should be shown")
    public void no_channel_result_should_be_shown() throws InterruptedException {
        searchChannel.no_channel_results_should_be_shown();
    }
}

