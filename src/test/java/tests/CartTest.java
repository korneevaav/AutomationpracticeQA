package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.Retry;

public class CartTest extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    @Description("Add Product to Cart from Product page")
    public void addProductToCartFromProductPage() {
        cartSteps
                .openPage()
                .openProductByName("Blouse")
                .addProductToCart(2)
                .checkNumberOfProductsInCart(2);
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Remove previously added Product from Cart")
    public void removeProductFromCart() {
        cartSteps
                .openPage()
                .openProductByName("Blouse")
                .addProductToCart(2)
                .checkNumberOfProductsInCart(2)
                .removeProductFromCart()
                .checkNumberOfProductsInCart(0);
    }
}
