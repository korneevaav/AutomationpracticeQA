package steps;

import io.qameta.allure.Step;
import models.User;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class LoginSteps extends BaseSteps {
    @Step("Open Authentication page")
    public LoginSteps openPage() {
        authenticationPage.openPage();

        return this;
    }

    @Step("Fill Login Data")
    public LoginSteps fillLoginData(User user) {
        authenticationPage.setEmail(user.getEmail()).setPassword(user.getPassword());

        return this;
    }

    @Step("Click Login button")
    public LoginSteps clickLoginButton() {
        authenticationPage.clickLoginButton();

        return this;
    }

    @Step("Check Login successful")
    public void checkLoginSuccessful(User user) {
        assertEquals(url(), accountPage.getUrl());
        assertEquals(accountPage.getHeadingUserName(), user.getFirstName() + " " + user.getLastName());
    }

    @Step("Check not-successful Login error message")
    public void checkNotSuccessfulLogin() {
        assertNotEquals(url(), accountPage.getUrl());
        authenticationPage.isErrorSectionVisisble();
    }
}
