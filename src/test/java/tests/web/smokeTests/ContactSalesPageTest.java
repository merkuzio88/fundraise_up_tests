package tests.web.smokeTests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ContactSalesPage;
import pages.MainPage;
import tests.web.TestBase;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Tag("ui_tests")
public class ContactSalesPageTest extends TestBase {

    MainPage mainPage = new MainPage();
    ContactSalesPage contactSalesPage = new ContactSalesPage();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Open contact sales page and check title and talk to sales button")
    void openContactSalesPageAndCheckTitleAndButtonTest() {
        mainPage.openMainPage()
                .openContactSalesPage();
        contactSalesPage.checkPageHeader()
                .checkTalkToSalesButton();
    }
}
