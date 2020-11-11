package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class HomePage extends BasePage {
    private static final String URL = "http://automationpractice.com/index.php";

    private static final By SEARCH_INPUT = By.id("search_query_top");
    private static final By SEARCH_BUTTON = By.xpath("//button[@class='btn btn-default button-search']");
    private static final By SIGN_IN_BUTTON = By.className("login");

    @Step("Open page: " + URL)
    public HomePage openPage() {
        open(URL);

        log.info("Open page: " + URL);

        return this;
    }

    @Step("Open Product by name: {productName}")
    public ProductPage openProductByName(String productName) {
        $(By.linkText(productName)).click();

        log.info("Open product: " + productName);

        return new ProductPage();
    }

    @Step("Set Search text: {searchString}")
    public HomePage setSearchText(String searchString) {
        $(SEARCH_INPUT).sendKeys(searchString);

        log.info("Search text \"" + searchString + "\" is set");

        return this;
    }

    @Step("Click Search button")
    public SearchResultPage clickSearchButton() {
        $(SEARCH_BUTTON).click();

        log.info("Click Search button");

        return new SearchResultPage();
    }

    public AuthenticationPage clickSignInButton() {
        $(SIGN_IN_BUTTON).click();

        log.info("Click Sign In button");

        return new AuthenticationPage();
    }
}
