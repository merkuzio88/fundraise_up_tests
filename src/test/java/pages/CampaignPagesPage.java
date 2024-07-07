package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.UiHelpers.clickWithAttempts;

public class CampaignPagesPage {

    private final SelenideElement faqAccordion = $("div.p-abs.centered svg.d-block path[fill-rule='evenodd']");
    private final SelenideElement faqExpandedText = $(".overflow-hidden[style='height: 44px; opacity: 1;']");

    @Step("Open campaign pages page")
    public CampaignPagesPage openCampaignPagesPage() {
        open("/features/campaign-pages/");
        return this;
    }

    @Step("Check faq hidden text display")
    public CampaignPagesPage checkFaqHiddenTextDisplay() {
        clickWithAttempts(faqAccordion, faqExpandedText, visible);
        return this;
    }
}
