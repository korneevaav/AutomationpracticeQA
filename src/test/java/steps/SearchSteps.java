package steps;

import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

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

    @Step("Check Search results number")
    public void numberOfResultShouldBe(int expSearchResultNumber) {
        assertEquals(searchResultPage.getSearchResultsNumber(), expSearchResultNumber);
    }
}
