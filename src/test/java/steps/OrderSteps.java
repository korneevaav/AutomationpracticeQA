package steps;

import io.qameta.allure.Step;
import models.User;

import static org.testng.Assert.assertEquals;

public class OrderSteps extends BaseSteps {
    public static final String ORDER_SUCCESSFUL_TEXT = "Your order on My Store is complete.";

    @Step("Open Home page")
    public OrderSteps openPage() {
        homePage.openPage();

        return this;
    }

    @Step("Login")
    public OrderSteps login(User user) {
        homePage
                .clickSignInButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButton();

        assertEquals(accountPage.getHeadingUserName(), user.getFirstName() + " " + user.getLastName());

        return this;
    }

    @Step("Add product to Cart with count: {productQuantity} with quantity: {productQuantity}")
    public OrderSteps addProductToCart(String productName, int productQuantity) {
        accountPage.clickOnLogo();

        homePage.openProductByName(productName);

        productPage
                .setProductQuantity(productQuantity)
                .clickAddToCartButton();

        return this;
    }

    @Step("ProceedToCheckout")
    public OrderSteps proceedToCheckout() {
        productPage.clickProceedToCheckoutButton();

        return this;
    }

    @Step("Check Delivery Address")
    public OrderSteps checkDeliveryAddressInfo(User user) {
        assertEquals(orderPage.getAddressName(), user.getFirstName() + " " + user.getLastName());
        assertEquals(orderPage.getAddress(), user.getAddress());
        assertEquals(orderPage.getAddressCity(), user.getCity() + ", " + user.getState() + " " + user.getPostalCode());
        assertEquals(orderPage.getAddressPhone(), user.getPhone());

        return this;
    }

    @Step("Accept Terms of Service")
    public OrderSteps acceptTermsOfService() {
        orderPage.setCgvCheckbox();

        return this;
    }

    @Step("Pay by Bank Wire")
    public OrderSteps payByBankWire() {
        orderPage.clickPayByBankWireButton();

        return this;
    }

    @Step("Confirm Order")
    public OrderSteps confirmOrder() {
        orderPage.clickConfirmOrderButton();

        return this;
    }

    @Step("Check order successful")
    public void checkOrderSuccessful() {
        assertEquals(orderPage.getOrderSuccessfulText(), ORDER_SUCCESSFUL_TEXT);
    }

    @Step("Submit Symmary")
    public OrderSteps submitSummary() {
        orderPage.clickProceedToCheckoutSummaryButton();

        return this;
    }

    @Step("Submit Address")
    public OrderSteps submitAddress() {
        orderPage.clickProceedToCheckoutAddressButton();

        return this;
    }

    @Step("Submit Shipping")
    public OrderSteps submitShipping() {
        orderPage.clickProceedToCheckoutShippingButton();

        return this;
    }
}
