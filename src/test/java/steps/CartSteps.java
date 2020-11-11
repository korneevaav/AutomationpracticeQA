package steps;

import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class CartSteps extends BaseSteps {
    @Step("Open Home page")
    public CartSteps openPage() {
        homePage.openPage();

        return this;
    }

    @Step("Open Product page by Product name: {productName}")
    public CartSteps openProductByName(String productName) {
        homePage.openProductByName(productName);

        return this;
    }

    @Step("Add product to Cart with count: {productQuantity}")
    public CartSteps addProductToCart(int productQuantity) {
        productPage
                .setProductQuantity(productQuantity)
                .clickAddToCartButton();

        return this;
    }

    @Step("Check number of Products added to Cart")
    public void checkNumberOfProductsInCart(int expCartQuantity) {
        assertEquals(productPage.getCartQuantity(), expCartQuantity);
    }
}
