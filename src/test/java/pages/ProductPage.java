package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProductPage extends BasePage {
    private static final By ADD_TO_CART_BUTTON = By.xpath("//div[@class='box-cart-bottom']//button[@name='Submit']");
    private static final By REMOVE_FROM_CART_BUTTON = By.className("ajax_cart_block_remove_link");
    private static final By CART_QUANTITY_TEXT = By.className("ajax_cart_quantity");
    private static final By QUANTITY_INPUT = By.id("quantity_wanted");
    private static final By CLOSE_POP_UP_BUTTON = By.className("cross");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//a[@class='btn btn-default button button-medium']");
    private static final By SHOPPING_CART_BLOCK = By.className("shopping_cart");

    @Step("Click Add to Cart button")
    public ProductPage clickAddToCartButton() {
        $(ADD_TO_CART_BUTTON).click();

        log.info("Click Add to Cart button");

        return this;
    }

    @Step("Get Cart Quantity")
    public int getCartQuantity() {
        String str;

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if ($(CART_QUANTITY_TEXT).is(Condition.visible)) {
            str = $(CART_QUANTITY_TEXT).waitUntil(Condition.visible, 5000).text();
        } else {
            str = "0";
        }

        log.info("Cart Quantity: " + str);

        return Integer.parseInt(str);
    }

    @Step("Set Product quantity: {productQuantity}")
    public ProductPage setProductQuantity(int productQuantity) {
        $(QUANTITY_INPUT).clear();
        $(QUANTITY_INPUT).sendKeys(Integer.toString(productQuantity));

        log.info("Set Product quantity: " + productQuantity);

        return this;
    }

    @Step("Close pop up window")
    public ProductPage clickClosePopUpButton() {
        $(CLOSE_POP_UP_BUTTON).click();

        log.info("Close pop up window");

        return this;
    }

    @Step("Click Proceed to checkout button")
    public ProductPage clickProceedToCheckoutButton() {
        $(PROCEED_TO_CHECKOUT_BUTTON).waitUntil(Condition.visible, 5000).click();

        log.info("Click Proceed to checkout button");

        return this;
    }

    @Step("Click Remove Product from Cart button")
    public ProductPage clickRemoveProductFromCartButton() {
        $(SHOPPING_CART_BLOCK).hover();
        $(REMOVE_FROM_CART_BUTTON).waitUntil(Condition.visible, 5000).click();

        log.info("Click Remove Product form Cart button");

        return this;
    }
}
