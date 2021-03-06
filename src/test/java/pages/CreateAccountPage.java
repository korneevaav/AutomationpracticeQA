package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class CreateAccountPage extends BasePage {
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";

    private static final By ERROR_LIST = By.xpath("//div[@class='alert alert-danger']//ol//li");
    private static final By REGISTER_BUTTON = By.id("submitAccount");
    private static final By FIRST_NAME_INPUT = By.id("customer_firstname");
    private static final By LAST_NAME_INPUT = By.id("customer_lastname");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By ADDRESS_INPUT = By.id("address1");
    private static final By CITY_INPUT = By.id("city");
    private static final By STATE_SELECT = By.id("id_state");
    private static final By POSTAL_CODE_INPUT = By.id("postcode");
    private static final By COUNTRY_SELECT = By.id("id_country");
    private static final By PHONE_INPUT = By.id("phone_mobile");

    @Step("Set First Name: {firstName}")
    public CreateAccountPage setFirstName(String firstName) {
        $(FIRST_NAME_INPUT).scrollTo().sendKeys(firstName);

        log.info("Set first name: " + firstName);

        return this;
    }

    @Step("Set Last Name: {lastName}")
    public CreateAccountPage setLastName(String lastName) {
        $(LAST_NAME_INPUT).sendKeys(lastName);

        log.info("Set last name: " + lastName);

        return this;
    }

    @Step("Set Password: {password}")
    public CreateAccountPage setPassword(String password) {
        $(PASSWORD_INPUT).sendKeys(password);

        log.info("Set password: " + password);

        return this;
    }

    @Step("Set Address: {address}")
    public CreateAccountPage setAddress(String address) {
        $(ADDRESS_INPUT).sendKeys(address);

        log.info("Set address: " + address);

        return this;
    }

    @Step("Set City: {city}")
    public CreateAccountPage setCity(String city) {
        $(CITY_INPUT).sendKeys(city);

        log.info("Set city: " + city);

        return this;
    }

    @Step("Set State: {state}")
    public CreateAccountPage setState(String state) {
        $(STATE_SELECT).click();

        new Select($(STATE_SELECT)).selectByVisibleText(state);

        log.info("Set state: " + state);

        return this;
    }

    @Step("Set Postal Code: {postalCode}")
    public CreateAccountPage setPostalCode(String postalCode) {
        $(POSTAL_CODE_INPUT).sendKeys(postalCode);

        log.info("Set postal code: " + postalCode);

        return this;
    }

    @Step("Set Country: {country}")
    public CreateAccountPage setCountry(String country) {
        new Select($(COUNTRY_SELECT)).selectByValue(country);

        log.info("Set country: " + country);

        return this;
    }

    @Step("Set Phone: {phone}")
    public CreateAccountPage setPhone(String phone) {
        $(PHONE_INPUT).sendKeys(phone);

        log.info("Set phone: " + phone);

        return this;
    }

    @Step("Click Register button")
    public AccountPage clickRegisterButton() {
        $(REGISTER_BUTTON).click();

        log.info("Click Register button");

        return new AccountPage();
    }

    @Step("Get number of Registration errors")
    public int getNumberOfErrors() {
        int numberOfErrors = $$(ERROR_LIST).size();

        log.info("Number of errors: " + numberOfErrors);

        return numberOfErrors;
    }
}
