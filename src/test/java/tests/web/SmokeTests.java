package tests.web;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ContactSalesPage;
import pages.MainPage;

public class SmokeTests extends TestBase {

    MainPage mainPage = new MainPage();
    ContactSalesPage contactSalesPage = new ContactSalesPage();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open contact sales page and check title and talk to sales button")
    void openContactSalesPageAndCheckTitleAndButtonTest() {
        mainPage.openMainPage()
                .openContactSalesPage();
        contactSalesPage.checkPageHeader()
                .checkTalkToSalesButton();
    }
}
