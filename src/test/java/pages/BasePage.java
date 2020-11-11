package pages;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {
    public String getCurrentUrl() {
        return url();
    }
}
