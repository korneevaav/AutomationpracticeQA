package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.data.TestDataGenerator;

public class OrderTest extends BaseTest {
    User registeredUser = TestDataGenerator.getRegisteredUser();

    @Test()
    @Description("Full scenario of Proceed to checkout")
    public void orderConfirmationAndPayment() {
        orderSteps
                .openPage()
                .login(registeredUser)
                .addProductToCart("Blouse", 2)
                .proceedToCheckout()
                .checkDeliveryAddressInfo(registeredUser)
                .submitSummary()
                .submitAddress()
                .acceptTermsOfService()
                .submitShipping()
                .payByBankWire()
                .confirmOrder()
                .checkOrderSuccessful();
    }
}
