package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    @Description("Add Product to Cart from Product page")
    public void addProductToCartFromProductPage() {
        cartSteps
                .openPage()
                .openProductByName("Blouse")
                .addProductToCart(2)
                .checkNumberOfProductsInCart(2);
    }

    @Test
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
