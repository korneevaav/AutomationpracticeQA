package steps;

import pages.*;

public class BaseSteps {
    HomePage homePage;
    AuthenticationPage authenticationPage;
    SearchResultPage searchResultPage;
    WomanCatalogPage womanCatalogPage;
    CreateAccountPage createAccountPage;
    AccountPage accountPage;
    ProductPage productPage;

    public BaseSteps() {
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        searchResultPage = new SearchResultPage();
        womanCatalogPage = new WomanCatalogPage();
        createAccountPage = new CreateAccountPage();
        accountPage = new AccountPage();
        productPage = new ProductPage();
    }
}
