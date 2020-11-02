package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static org.testng.Assert.assertEquals;

@Log4j2
public class SearchSteps extends BaseSteps {
    @Step("Open Home page")
    public SearchSteps openPage() {
        homePage.openPage();

        return this;
    }

    @Step("Search by text: {searchText}")
    public SearchSteps search(String searchText) {
        homePage
                .setSearchText(searchText)
                .clickSearchButton();

        return this;
    }

    @Step("Validate Search results number")
    public void validateSearchResultsNumber(int expSearchResultNumber) {
        assertEquals(searchResultPage.getSearchResultsNumber(), expSearchResultNumber);
    }
}
