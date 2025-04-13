package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class CheckoutSteps {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ProductDetail productDetailPage = new ProductDetail();
    Cart orderCart = new Cart();
    Checkout checkoutPage = new Checkout();
    Payment paymentPage = new Payment();
    PaymentReceived paymentReceivedPage = new PaymentReceived();

    @Given("User Click a product to checkout")
    public void clickProductToCheckout() throws InterruptedException {
        LoginSteps login = new LoginSteps();
        login.clickLoginBtn();
        login.enterCredentials();
        login.clickOnLoginBtn();
        homePage.assertHomePageDisplayed();
        homePage.clickProduct();
        productDetailPage.assertProductDetailDisplayed();
    }

    @When("User enters intended color and quantity")
    public void chooseProductSpec() throws InterruptedException {
        productDetailPage.clickBlueColor();
        productDetailPage.addQuantity();
        productDetailPage.addToCart();
    }

    @And("User proceed to checkout from cart")
    public void proceedCheckoutShipping() throws InterruptedException {
        productDetailPage.clickCart();
        orderCart.clickProceedPaymentBtn();
        checkoutPage.assertCheckoutPageDisplayed();
        checkoutPage.fillInCheckoutDetails("Putri Ainur", "Alam Sutera", "Tangerang", "101892", "Banten", "Indonesia");
        checkoutPage.clickContinuePayment();
    }

    @And("User complete payment")
    public void completePayment() {
        paymentPage.assertPaymentFormDisplayed();
        paymentPage.enterPaymentDetails("Putri Ainur", "41111111111", "0126", "111");
        paymentPage.clickReviewOrder();
        paymentPage.clickPaymentBtn();
    }

    @Then("User should be redirected to Payment Received Page")
    public void assertOrderComplete() {
        paymentReceivedPage.assertPaymentReceived();
        paymentReceivedPage.clickContinueShopping();
    }
}
