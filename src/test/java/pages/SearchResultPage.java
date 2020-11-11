package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class SearchResultPage extends BasePage {
    private static final By SEARCH_RESULT_NUMBER_TEXT = By.xpath("//div[@id='center_column']//span[@class='heading-counter']");

    @Step("Get Search results number")
    public int getSearchResultsNumber() {
        String searchResultText = $(SEARCH_RESULT_NUMBER_TEXT).text();

        return Integer.parseInt(searchResultText.trim().substring(0, 1));
    }
}
