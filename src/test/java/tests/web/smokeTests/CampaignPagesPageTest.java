package tests.web.smokeTests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CampaignPagesPage;
import tests.web.TestBase;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("ui_tests")
public class CampaignPagesPageTest extends TestBase {

    CampaignPagesPage campaignPagesPage = new CampaignPagesPage();

    @Test
    @Severity(CRITICAL)
    @DisplayName("Check FAQ text display on campaign pages page")
    void checkFaqTextsDisplayOnCampaignPagesTest() {
        campaignPagesPage.openCampaignPagesPage()
                .checkFaqHiddenTextDisplay();
    }
}
