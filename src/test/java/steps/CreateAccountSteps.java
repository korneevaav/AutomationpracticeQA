package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.User;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CreateAccountSteps extends BaseSteps {
    @Step("Open Create Account page")
    public CreateAccountSteps openPage(String email) {
        authenticationPage
                .openPage()
                .setEmailCreate(email)
                .clickCreateAccountButton();

        return this;
    }

    @Step("Fill Registration data")
    public CreateAccountSteps fillRegisterData(User user) {
        createAccountPage
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setAddress(user.getAddress())
                .setCity(user.getCity())
                .setState(user.getState())
                .setPostalCode(user.getPostalCode())
                .setCountry(user.getCountry())
                .setPhone(user.getPhone());

        return this;
    }

    @Step("Click Register button")
    public CreateAccountSteps register() {
        createAccountPage.clickRegisterButton();

        return this;
    }

    @Step("Check Registration successful")
    public void checkRegistrationSuccessful(User user) {
        assertEquals(accountPage.getHeadingUserName(), user.getFirstName() + " " + user.getLastName());
    }

    @Step("Check number of Registration errors")
    public void validateRegistration(int expNumberOfErrors) {
        assertEquals(createAccountPage.getNumberOfErrors(), expNumberOfErrors);
    }

    @Step("Check error message after clicking Create account button with already registered email")
    public void checkRegisteredEmailError() {
        String expErrorText = "An account using this email address has already been registered. Please enter a valid password or request a new one. ";
        assertEquals(authenticationPage.getCreateErrorText().trim(), expErrorText.trim());
    }
}
