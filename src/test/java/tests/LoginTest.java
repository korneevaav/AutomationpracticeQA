package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.data.TestDataGenerator;

public class LoginTest extends BaseTest {
    User registeredUser = TestDataGenerator.getRegisteredUser();
    User newUser = TestDataGenerator.getNewValidUser();

    @Test
    @Description("Login with registered User")
    public void loginWithRegisteredUser() {
        loginSteps
                .openPage()
                .fillLoginData(registeredUser)
                .clickLoginButton()
                .checkLoginSuccessful(registeredUser);
    }

    @Test
    @Description("Login with not-registered User")
    public void loginWithNotRegisteredUser() {
        loginSteps
                .openPage()
                .fillLoginData(newUser)
                .clickLoginButton()
                .checkNotSuccessfulLogin();
    }
}
