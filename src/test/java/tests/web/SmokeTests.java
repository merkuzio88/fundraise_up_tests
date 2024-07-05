package tests.web;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class SmokeTests extends TestBase {

    MainPage mainPage = new MainPage();
    ContactSalesPage contactSalesPage = new ContactSalesPage();
    FeaturesPage featuresPage = new FeaturesPage();
    CampaignPagesPage campaignPagesPage = new CampaignPagesPage();
    LoginPage loginPage = new LoginPage();
    LanguagesPage languagesPage = new LanguagesPage();
    DocsChangelogPage docsChangelogPage = new DocsChangelogPage();
    PaypalRecurringPage paypalRecurringPage = new PaypalRecurringPage();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Open contact sales page and check title and talk to sales button")
    void openContactSalesPageAndCheckTitleAndButtonTest() {
        mainPage.openMainPage()
                .openContactSalesPage();
        contactSalesPage.checkPageHeader()
                .checkTalkToSalesButton();
    }

    @Test
    @Severity(BLOCKER)
    @DisplayName("Open features page and check title and explore campaign link")
    void openFeaturesPageAndCheckTitleAndLinkTest() {
        mainPage.openMainPage()
                .openFeaturesPage();
        featuresPage.checkPageHeader()
                .checkExploreCampaignLink();
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Check FAQ text display on campaign pages page")
    void checkFaqTextsDisplayOnCampaignPagesTest() {
        campaignPagesPage.openCampaignPagesPage()
                .checkFaqHiddenTextDisplay();
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Check error message with unsuccessful login attempt")
    void checkErrorMessageWithUnsuccessfulLoginAttempt() {
        loginPage.openLoginPage()
                .fillRandomDataAndSubmitAttempt()
                .checkErrorMessageWithUnsuccessfulLogin();
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Check that number of languages in header corresponds to number of icons")
    void checkNumberOfLanguagesInHeaderCorrespondsToNumberOfIcons() {
        languagesPage.openLanguagesPage()
                .checkNumberOfLanguageIcons();
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Check that successful subscribe to docs updates message equals to expected")
    void checkSuccessfulSubscribeToDocsUpdatesMessage() {
        docsChangelogPage.openDocsChangelogPage()
                .checkSuccessfulSubscribeMessage();
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Check that successful PayPal recurring request message equals to expected")
    void checkSuccessfulPaypalRecurringRequestMessage() {
        paypalRecurringPage.openPaypalRecurringPage()
                .fillRandomDataAndCheckPaypalRecurringRequestMessage();
    }
}
