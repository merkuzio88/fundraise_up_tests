package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutPage {

    private final SelenideElement header = $("h1.h2");
    private final SelenideElement tryCheckoutButton = $(".p-rel .label-1.p-rel");
    private final SelenideElement widgetFrame = $("[title='Donation Widget']");
    private final SelenideElement widgetWindow = $(".widget.widget-desktop");

    @Step("Open checkout trying page")
    public CheckoutPage openCheckoutPage() {
        open("/features/checkout/");
        header.shouldBe(visible);
        return this;
    }

    @Step("Click try checkout button and check widget window")
    public CheckoutPage checkWidgetWindow() {
        tryCheckoutButton.click();
        switchTo().frame(widgetFrame);
        widgetWindow.shouldBe(visible);
        return this;
    }
}
