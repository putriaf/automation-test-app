package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Driver {
    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> initializeDriver(String platform) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel3");
        capabilities.setCapability("app", "/Users/putri.fitri/Downloads/saucelabs.apk");
        capabilities.setCapability("appPackage", "com.saucelabs.mydemoapp.android");
        capabilities.setCapability("appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        capabilities.setCapability("automationName", "UiAutomator2");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<>(url, capabilities);

        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
