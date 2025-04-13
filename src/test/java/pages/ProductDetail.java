package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.sl.In;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class ProductDetail {


    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private MobileElement lblProductDetailHeader;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private MobileElement lblPrice;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Blue color\"]")
    private MobileElement ctrBlueColor;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private MobileElement btnPlusQty;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private MobileElement btnAddToCart;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private MobileElement ctrCart;

    public ProductDetail() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
    }

    CommonMethod commonMethod = new CommonMethod();

    public void scrollToElementUsingElement(AppiumDriver<WebElement> driver, WebElement element, Integer maxSwipeCounter) throws InterruptedException {
        if (maxSwipeCounter == null) {
            maxSwipeCounter = 10;
        }
        String elementLocator;
        try {
            elementLocator = element.toString().split("->")[1];
        } catch (Exception e) {
            elementLocator = element.toString();
        }
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width / 2.2);
        int starty, endy;
        int elementy;

        starty = (int) (size.height * 0.4);
        endy = (int) (size.height * 0.2);

        Boolean isFoundElement = element.isDisplayed();

        int attempt = 0;
        while (!isFoundElement) {
            new TouchAction(driver).press(point(startx, starty)).waitAction(waitOptions(Duration.ofSeconds(1)))
                    .moveTo(point(startx, endy)).release().perform();
            attempt++;

            if (attempt==maxSwipeCounter && !isFoundElement) {
                break;
            }
        }
        if (isFoundElement) {
            elementy = element.getLocation().getY();
            float elementyInPercentage = ((float) elementy) / size.height;
            if(elementyInPercentage > 0.98) {
                try {
                    swipeUpSmallScreen(driver);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void swipeUpSmallScreen(AppiumDriver<WebElement> driver) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.5);
        int startX = (int) (size.width * 0.5);

        if (driver instanceof AndroidDriver) {
            int dynamicRangeY = (int) (size.height * 0.1);
            int endY = startY - dynamicRangeY;
            try {
                Thread.sleep(2000);
                new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(startX, endY)).release().perform();
            } catch (InvalidElementStateException e) {
                Thread.sleep(1000);
                new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(startX, endY)).release().perform();
            }
        }
        else if (driver instanceof IOSDriver) {
            int dynamicRangeY = (int) (size.height *0.1);
            int endY = startY - dynamicRangeY;
            new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(startX,endY)).release().perform();
        }

        Thread.sleep(500);
    }

    public void assertProductDetailDisplayed() throws InterruptedException {
        lblProductDetailHeader.isDisplayed();
        ctrBlueColor.isDisplayed();
    }

    public void clickBlueColor() {
        commonMethod.hardScroll(2);
        ctrBlueColor.click();
    }

    public void addQuantity() throws InterruptedException {
        commonMethod.hardScroll(2);
        btnPlusQty.click();
    }

    public void addToCart() {
        btnAddToCart.isDisplayed();
        btnAddToCart.click();
    }

    public void clickCart() {
        ctrCart.click();
    }

}
