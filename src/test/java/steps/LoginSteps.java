package steps;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.HomePage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("User Click Login button on Sidebar")
    public void clickLoginBtn() {
        homePage.assertHomePageDisplayed();
        homePage.clickHamburgerMenu();
        homePage.clickLoginBtn();
        loginPage.assertLoginPageDisplayed();
    }

    @When("User enters valid username and password")
    public void enterCredentials() {
        loginPage.assertLoginPageDisplayed();
        loginPage.enterUsername("bod@example.com");
        loginPage.enterPassword("10203040");
    }

    @And("User taps the login button")
    public void clickOnLoginBtn() {
        loginPage.tapLoginButton();
    }

    @Then("User should be redirected to the Home Page")
    public void assertLoggedIn() {
        homePage.assertHomePageDisplayed();
        homePage.assertLoggedIn();
    }
}
