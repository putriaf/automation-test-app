package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Payment {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/nameTV")
    private MobileElement lblName;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private MobileElement tfName;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberTV")
    private MobileElement lblCardNumber;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberET")
    private MobileElement tfCardNumber;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateTV")
    private MobileElement lblExpirationDate;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateET")
    private MobileElement tfExpirationDate;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeTV")
    private MobileElement lblCVV;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeET")
    private MobileElement tfCVV;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private MobileElement btnReviewOrder;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private MobileElement btnPayment;

    public Payment() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
    }
    public void assertPaymentFormDisplayed() {
        lblName.isDisplayed();
        tfName.isDisplayed();
        lblCardNumber.isDisplayed();
        tfCardNumber.isDisplayed();
        lblExpirationDate.isDisplayed();
        lblCVV.isDisplayed();
        tfCVV.isDisplayed();
        btnReviewOrder.isDisplayed();
    }

    public void enterPaymentDetails(String name, String cardNumber, String expirationDate, String CVV) {
        tfName.sendKeys(name);
        tfCardNumber.sendKeys(cardNumber);
        tfExpirationDate.sendKeys(expirationDate);
        tfCVV.sendKeys(CVV);
    }

    public void clickReviewOrder() {
        btnReviewOrder.click();
    }

    public void clickPaymentBtn() {
        btnPayment.isDisplayed();
        btnPayment.click();
    }
}
