package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.Retry;
import utils.data.TestDataGenerator;

public class CreateAccountTest extends BaseTest {
    User validUser = TestDataGenerator.getNewValidUser();
    User registeredUser = TestDataGenerator.getRegisteredUser();

    @Test(retryAnalyzer = Retry.class)
    @Description("New User creation with valid data")
    public void createNewUser() {
        createAccountSteps
                .openPage(validUser.getEmail())
                .fillRegisterData(validUser)
                .register()
                .checkRegistrationSuccessful(validUser);
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Check number of errors if Register button clicked with empty fields")
    public void checkRegistrationErrorsNumber() {
        createAccountSteps
                .openPage("nastya.test@gmail.com")
                .register()
                .numberOfErrorsShouldBe(8);
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Creation of new account with already registered email")
    public void createNewUserWithRegisteredEmail() {
        createAccountSteps
                .openPage(registeredUser.getEmail())
                .checkRegisteredEmailError();
    }
}
