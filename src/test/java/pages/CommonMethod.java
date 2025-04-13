package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class CommonMethod {

    public CommonMethod() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
    }

    public void hardScroll(Integer maxAttempt) {
        Dimension size = Driver.driver.manage().window().getSize();

        int startX = (int) (size.width * 0.5);  // Center horizontally
        int startY = (int) (size.height * 0.8); // Start near the bottom of the screen
        int endY = (int) (size.height * 0.2);   // End near the top of the screen

        // Perform 10 scroll actions without checking for the element
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            new TouchAction(Driver.driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(startX, endY))
                    .release().perform();
        }
    }
}
