package steps;

import pages.*;

public class BaseSteps {
    HomePage homePage;
    AuthenticationPage authenticationPage;
    SearchResultPage searchResultPage;
    CreateAccountPage createAccountPage;
    AccountPage accountPage;
    ProductPage productPage;
    OrderPage orderPage;

    public BaseSteps() {
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        searchResultPage = new SearchResultPage();
        createAccountPage = new CreateAccountPage();
        accountPage = new AccountPage();
        productPage = new ProductPage();
        orderPage = new OrderPage();
    }
}
