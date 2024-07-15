package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import tests.TestData;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PaypalRecurringPage {

    private final SelenideElement header = $("h1");
    private final SelenideElement emailInput = $("input[id='126e10fc-3071-4c46-a337-9982451cfc81']");
    private final SelenideElement paypalEmailInput = $("input[id='dc2aaed7-9bf1-4f09-bca5-5005c30f5595']");
    private final SelenideElement fundraiseAccountId = $("input[aria-label='Please provide your Fundraise Up Account ID'");
    private final SelenideElement paypalMerchantIdInput = $("input[aria-label='PayPal Merchant ID'");
    private final SelenideElement submitButton = $("button[type='submit']");
    private final SelenideElement newPageSign = $("progress[value='2']");
    private final SelenideElement paypalRecurringRequestMessage = $("div.tally-text");
    private final String requestMessageText = "Thank you, we've received your request!";

    @Step("Open paypal recurring page")
    public PaypalRecurringPage openPaypalRecurringPage() {
        open("https://forms.fundraiseup.com/paypal-recurring");
        header.shouldBe(visible);
        return this;
    }

    @Step("Fill in the fields with random data and check PayPal recurring request message")
    public PaypalRecurringPage fillRandomDataAndCheckPaypalRecurringRequestMessage() {
        TestData testData = new TestData();
        emailInput.sendKeys(testData.randomEmail);
        paypalEmailInput.sendKeys(testData.randomEmail);
        fundraiseAccountId.sendKeys(testData.randomPaypalMerchantId);
        paypalMerchantIdInput.sendKeys(testData.randomPaypalMerchantId);
        submitButton.click();
        newPageSign.shouldBe(exist);
        Assertions.assertThat(paypalRecurringRequestMessage.getText())
                .withFailMessage("Actual PayPal recurring request message '%s' is not contains expected message '%s'",
                        paypalRecurringRequestMessage.getText(), requestMessageText)
                .contains(requestMessageText);
        return this;
    }
}
