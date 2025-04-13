package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private MobileElement lblProductHeader;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private MobileElement btnHamburgerMenu;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Login Menu Item']")
    private MobileElement btnLogin;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Logout Menu Item\"]")
    private MobileElement btnLogout;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Product Image\"][1]")
    private MobileElement ctrProduct;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
    }

    public void assertHomePageDisplayed() {
        lblProductHeader.isDisplayed();
        btnHamburgerMenu.isDisplayed();
    }

    public void clickHamburgerMenu() {
        btnHamburgerMenu.click();
    }

    public void clickLoginBtn() {
        btnLogin.isDisplayed();
        btnLogin.click();
    }

    public void assertLoggedIn() {
        btnHamburgerMenu.click();
        btnLogout.isDisplayed();
    }

    public void clickProduct() {
        ctrProduct.click();
    }

}
