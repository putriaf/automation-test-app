package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Checkout {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
    private MobileElement lblCheckoutHeader;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameTV")
    private MobileElement lblFullName;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
    private MobileElement tfFullName;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/address1TV")
    private MobileElement lblAddress;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/address1ET")
    private MobileElement tfAddress;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cityTV")
    private MobileElement lblCity;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
    private MobileElement tfCity;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/zipTV")
    private MobileElement lblZipCode;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/zipET")
    private MobileElement tfZipCode;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/stateTV")
    private MobileElement lblRegion;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/stateET")
    private MobileElement tfRegion;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/countryTV")
    private MobileElement lblCountry;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/countryET")
    private MobileElement tfCountry;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private MobileElement btnContinuePayment;

    public Checkout() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
    }

    CommonMethod commonMethod = new CommonMethod();

    public void assertCheckoutPageDisplayed() {
        lblCheckoutHeader.isDisplayed();
        lblFullName.isDisplayed();
        tfFullName.isDisplayed();
        lblAddress.isDisplayed();
        tfAddress.isDisplayed();
        lblCity.isDisplayed();
        tfCity.isDisplayed();
        lblZipCode.isDisplayed();
        tfZipCode.isDisplayed();
        lblRegion.isDisplayed();
        tfRegion.isDisplayed();
        lblCountry.isDisplayed();
        tfCountry.isDisplayed();
    }

    public void fillInCheckoutDetails(String fullName, String address, String city, String zipCode, String region, String country) {
        tfFullName.sendKeys(fullName);
        tfAddress.sendKeys(address);
        tfCity.sendKeys(city);
        tfZipCode.sendKeys(zipCode);
        tfCountry.sendKeys(country);
        tfRegion.sendKeys(region);
    }

    public void clickContinuePayment() {
        commonMethod.hardScroll(1);
        btnContinuePayment.isDisplayed();
        btnContinuePayment.click();
    }

}
