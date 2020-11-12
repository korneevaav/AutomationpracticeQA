package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.Retry;
import utils.data.TestDataGenerator;

public class LoginTest extends BaseTest {
    User registeredUser = TestDataGenerator.getRegisteredUser();
    User newUser = TestDataGenerator.getNewValidUser();

    @Test(retryAnalyzer = Retry.class)
    @Description("Login with registered User")
    public void loginWithRegisteredUser() {
        loginSteps
                .openPage()
                .fillLoginData(registeredUser)
                .clickLoginButton()
                .checkLoginSuccessful(registeredUser);
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Login with not-registered User")
    public void loginWithNotRegisteredUser() {
        loginSteps
                .openPage()
                .fillLoginData(newUser)
                .clickLoginButton()
                .checkNotSuccessfulLogin();
    }
}
