package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FeaturesPage {

    private final SelenideElement header = $("h2");
    private final SelenideElement exploreCampaignPagesLink = $("[aria-label='Explore Campaign Pages']");

    @Step("Check features page header")
    public FeaturesPage checkPageHeader() {
        header.shouldBe(visible);
        return this;
    }

    @Step("Check explore campaign link")
    public FeaturesPage checkExploreCampaignLink() {
        exploreCampaignPagesLink.shouldBe(visible);
        return this;
    }
}
