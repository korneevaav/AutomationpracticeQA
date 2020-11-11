package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.*;
import utils.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    CreateAccountSteps createAccountSteps;
    LoginSteps loginSteps;
    SearchSteps searchSteps;
    CartSteps cartSteps;
    OrderSteps orderSteps;

    @BeforeMethod()
    public void setup() {
        Configuration.timeout = 5000;

        createAccountSteps = new CreateAccountSteps();
        loginSteps = new LoginSteps();
        searchSteps = new SearchSteps();
        cartSteps = new CartSteps();
        orderSteps = new OrderSteps();
    }

    @AfterMethod
    public void closeBrowser() {
        getWebDriver().quit();
    }
}
