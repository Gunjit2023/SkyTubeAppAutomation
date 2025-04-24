package pageObject;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SearchChannelModule {
        public By skyTubeHamburger = AppiumBy.accessibilityId("SkyTube");
        public By searchText = By.id("free.rm.skytube.oss:id/search_src_text");
        public By searchIcon = By.id("free.rm.skytube.oss:id/search_mag_icon");
 }

