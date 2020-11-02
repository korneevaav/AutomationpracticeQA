package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.*;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
    CreateAccountSteps createAccountSteps;
    LoginSteps loginSteps;
    SearchSteps searchSteps;
    CartSteps cartSteps;

    @BeforeMethod()
    public void setup() {
        createAccountSteps = new CreateAccountSteps();
        loginSteps = new LoginSteps();
        searchSteps = new SearchSteps();
        cartSteps = new CartSteps();
    }
}
