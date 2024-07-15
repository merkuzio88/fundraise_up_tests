package tests.web.smokeTests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FeaturesPage;
import pages.MainPage;
import tests.web.TestBase;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Tag("ui_tests")
public class FeaturesPageTest extends TestBase {

    MainPage mainPage = new MainPage();
    FeaturesPage featuresPage = new FeaturesPage();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Open features page and check title and explore campaign link")
    void openFeaturesPageAndCheckTitleAndLinkTest() {
        mainPage.openMainPage()
                .openFeaturesPage();
        featuresPage.checkPageHeader()
                .checkExploreCampaignLink();
    }
}
