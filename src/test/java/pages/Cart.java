package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Cart {
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private MobileElement btnProceedPayment;

    public Cart() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
    }
    public void clickProceedPaymentBtn() throws InterruptedException {
        Thread.sleep(2000);
        btnProceedPayment.isDisplayed();
        btnProceedPayment.click();
    }
}
