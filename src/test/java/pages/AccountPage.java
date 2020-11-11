package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class AccountPage extends BasePage {
    private static final String URL = "http://automationpractice.com/index.php?controller=my-account";

    private static final By HEADING_USER_NAME_TEXT = By.xpath("//div[@class='header_user_info']//a//span");
    private static final By LOGO = By.id("header_logo");

    @Step("Return Heading User Name")
    public String getHeadingUserName() {
        String userName = $(HEADING_USER_NAME_TEXT).text();

        log.info("Heading user name: " + userName);

        return userName;
    }

    @Step("Navigate to Home Page")
    public HomePage clickOnLogo() {
        $(LOGO).click();

        log.info("Click on Logo");

        return new HomePage();
    }

    public String getUrl() {
        return URL;
    }
}
