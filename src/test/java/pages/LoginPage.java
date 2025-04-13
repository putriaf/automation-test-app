package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginTV")
    private MobileElement lblLoginHeader;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/usernameTV")
    private MobileElement lblUsernameField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private MobileElement tfUsername;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/passwordTV")
    private MobileElement lblPasswordField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private MobileElement tfPassword;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private MobileElement btnLogin;

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.driver), this);
    }

    public void assertLoginPageDisplayed() {
        lblLoginHeader.isDisplayed();
        lblUsernameField.isDisplayed();
        tfUsername.isDisplayed();
        lblPasswordField.isDisplayed();
        tfPassword.isDisplayed();
        btnLogin.isDisplayed();
    }
    public void enterUsername(String username) {
        tfUsername.click();
        tfUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        tfPassword.click();
        tfPassword.sendKeys(password);
    }

    public void tapLoginButton() {
        btnLogin.click();
    }
}
