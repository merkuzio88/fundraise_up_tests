package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import tests.TestData;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.UiHelpers.clickWithAttempts;

public class DocsChangelogPage {

    private final SelenideElement header = $(byTagAndText("h3", "What’s new"));
    private final SelenideElement getUpdatesButton = $("button.cta-137540-trigger");
    private final SelenideElement subscribeModalHeader = $("#element4127403-content");
    private final SelenideElement emailInput = $("[section-id='1414546'] input[type='email']");
    private final SelenideElement subscribeButton = $("[section-id='1414546'] button.cf-button-inner");
    private final SelenideElement successfulSubscribeMessage = $("#element4552272-content h1");
    private final SelenideElement successCheckmark = $("svg.checkmark");
    private final String successfulSubscribeMessageText = "You're subscribed";

    @Step("Open languages page")
    public DocsChangelogPage openDocsChangelogPage() {
        open("/docs/changelog/");
        header.shouldBe(visible);
        return this;
    }

    @Step("Check successful subscribe to updates message")
    public DocsChangelogPage checkSuccessfulSubscribeMessage() {
        TestData testData = new TestData();
        clickWithAttempts(getUpdatesButton, subscribeModalHeader, visible);
        emailInput.sendKeys(testData.randomEmail);
        subscribeButton.click();
        successCheckmark.shouldBe(visible, Duration.ofSeconds(10));
        Assertions.assertThat(successfulSubscribeMessage.getText())
                .withFailMessage("Actual successful subscribe message '%s' is not equal to expected message '%s'",
                        successfulSubscribeMessage.getText(), successfulSubscribeMessageText)
                .isEqualTo(successfulSubscribeMessageText);
        return this;
    }
}
