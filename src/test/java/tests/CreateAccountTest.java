package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.data.TestDataGenerator;

public class CreateAccountTest extends BaseTest {
    User validUser = TestDataGenerator.getNewValidUser();
    User registeredUser = TestDataGenerator.getRegisteredUser();

    @Test
    @Description("New User creation with valid data")
    public void createNewUser() {
        createAccountSteps
                .openPage(validUser.getEmail())
                .fillRegisterData(validUser)
                .register()
                .checkRegistrationSuccessful(validUser);
    }

    @Test
    @Description("Check number of errors if Register button clicked with empty fields")
    public void checkRegistrationErrorsNumber() {
        createAccountSteps
                .openPage("nastya.test@gmail.com")
                .register()
                .validateRegistration(8);
    }

    @Test
    @Description("Creation of new account with already registered email")
    public void createNewUserWithRegisteredEmail() {
        createAccountSteps
                .openPage(registeredUser.getEmail())
                .checkRegisteredEmailError();
    }
}
