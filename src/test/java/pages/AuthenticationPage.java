package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class AuthenticationPage extends BasePage {
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    private static final By ERROR_CREATE_LIST = By.xpath("//div[@id='create_account_error']//ol//li");
    private static final By ERROR_LIST = By.xpath("//div[@class='alert alert-danger']");
    private static final By EMAIL_CREATE_INPUT = By.id("email_create");
    private static final By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By LOGIN_BUTTON = By.id("SubmitLogin");

    @Step("Open page: " + URL)
    public AuthenticationPage openPage() {
        open(URL);

        return this;
    }

    @Step("Set Email: {email}")
    public AuthenticationPage setEmail(String email) {
        log.info("Set email: {1}", email);
        $(EMAIL_INPUT).scrollTo().sendKeys(email);

        return this;
    }

    @Step("Set Password: {password}")
    public AuthenticationPage setPassword(String password) {
        log.info("Set password: {1}", password);
        $(PASSWORD_INPUT).sendKeys(password);

        return this;
    }

    @Step("Click Login button")
    public void clickLoginButton() {
        log.info("Login button clicked");
        $(LOGIN_BUTTON).click();
    }

    @Step("Set Email Create: {email}")
    public AuthenticationPage setEmailCreate(String email) {
        log.info("Set email create: {1}", email);
        $(EMAIL_CREATE_INPUT).sendKeys(email);

        return this;
    }

    @Step("Click Create an account button")
    public CreateAccountPage clickCreateAccountButton() {
        log.info("Create an account button clicked");
        $(CREATE_ACCOUNT_BUTTON).click();

        return new CreateAccountPage();
    }

    @Step("Get email already registered error message")
    public String getCreateErrorText() {
        return $$(ERROR_CREATE_LIST).first().text();
    }

    @Step("Check error section is visible")
    public AuthenticationPage isErrorSectionVisisble() {
        $(ERROR_LIST).shouldBe(Condition.visible);

        return this;
    }
}
