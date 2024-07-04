package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactSalesPage {

    private final SelenideElement header = $(".h2");
    private final SelenideElement talkToSalesButton = $(".hs-button.primary.large");

    @Step("Check contact sales page header")
    public ContactSalesPage checkPageHeader() {
        header.shouldBe(visible);
        return this;
    }

    @Step("Check talk to sales button")
    public ContactSalesPage checkTalkToSalesButton() {
        talkToSalesButton.shouldBe(visible);
        return this;
    }
}
