package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProductPage extends BasePage {
    private static final By ADD_TO_CART_BUTTON = By.xpath("//div[@class='box-cart-bottom']//button[@name='Submit']");
    private static final By CART_QUANTITY_TEXT = By.id("layer_cart_product_quantity");
    private static final By QUANTITY_INPUT = By.xpath("//input[@id='quantity_wanted']");

    @Step("Click Add to Cart button")
    public ProductPage clickAddToCartButton() {
        $(ADD_TO_CART_BUTTON).click();

        log.info("Add to Cart button clicked");

        return this;
    }

    @Step("Get Cart Quantity")
    public int getCartQuantity() {
        String str = $(CART_QUANTITY_TEXT).waitUntil(Condition.visible, 5000).text();
        return Integer.parseInt(str);
    }

    @Step("Set Product quantity: {productQuantity}")
    public ProductPage setProductQuantity(int productQuantity) {
        $(QUANTITY_INPUT).clear();
        $(QUANTITY_INPUT).sendKeys(Integer.toString(productQuantity));

        log.info("Product quantity is set to {1}", productQuantity);

        return this;
    }
}
