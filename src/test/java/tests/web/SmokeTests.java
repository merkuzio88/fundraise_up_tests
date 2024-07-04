package tests.web;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CampaignPagesPage;
import pages.ContactSalesPage;
import pages.FeaturesPage;
import pages.MainPage;

public class SmokeTests extends TestBase {

    MainPage mainPage = new MainPage();
    ContactSalesPage contactSalesPage = new ContactSalesPage();
    FeaturesPage featuresPage = new FeaturesPage();
    CampaignPagesPage campaignPagesPage = new CampaignPagesPage();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open contact sales page and check title and talk to sales button")
    void openContactSalesPageAndCheckTitleAndButtonTest() {
        mainPage.openMainPage()
                .openContactSalesPage();
        contactSalesPage.checkPageHeader()
                .checkTalkToSalesButton();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open features page and check title and explore campaign link")
    void openFeaturesPageAndCheckTitleAndLinkTest() {
        mainPage.openMainPage()
                .openFeaturesPage();
        featuresPage.checkPageHeader()
                .checkExploreCampaignLink();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check FAQ text display on campaign pages page")
    void checkFaqTextsDisplayOnCampaignPagesTest() {
        campaignPagesPage.openCampaignPagesPage()
                .checkFaqHiddenTextDisplay();
    }
}
