package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement talkToSalesButton = $(".btn.btn-primary");

    @Step("Open main page")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Open contact sales page")
    public MainPage openContactSalesPage() {
        talkToSalesButton.click();
        return this;
    }
}
