package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PaymentReceived {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/completeTV")
    private MobileElement lblOrderCompleted;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/thankYouTV")
    private MobileElement lblThankYou;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/swagTV")
    private MobileElement lblStatus;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/orderTV")
    private MobileElement lblOrderStatus;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/shoopingBt")
    private MobileElement btnContinueShopping;

    public PaymentReceived() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
    }

    public void assertPaymentReceived() {
        lblOrderCompleted.isDisplayed();
        lblStatus.isDisplayed();
        lblOrderStatus.isDisplayed();
        lblThankYou.isDisplayed();
        btnContinueShopping.isDisplayed();
    }

    public void clickContinueShopping() {
        btnContinueShopping.click();
    }
}
