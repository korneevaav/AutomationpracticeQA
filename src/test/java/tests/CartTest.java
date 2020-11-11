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
}
