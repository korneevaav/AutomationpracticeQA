package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.data.TestDataGenerator;

public class SearchTest extends BaseTest {
    @DataProvider(name = "Search Texts with Results Number")
    public Object[][] searchResults() {
        return TestDataGenerator.getSearchTextsWithResultsNumber();
    }

    @Test(dataProvider = "Search Texts with Results Number" )
    @Description("Search by text and check number of Search results")
    public void searchAndCheckResultsNumber(String searchText, int searchResultsNumber) {
        searchSteps
                .openPage()
                .search(searchText)
                .numberOfResultShouldBe(searchResultsNumber);
    }
}
