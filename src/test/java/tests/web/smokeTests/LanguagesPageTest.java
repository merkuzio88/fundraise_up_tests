package tests.web.smokeTests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LanguagesPage;
import tests.web.TestBase;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("ui_tests")
public class LanguagesPageTest extends TestBase {

    LanguagesPage languagesPage = new LanguagesPage();

    @Test
    @Severity(CRITICAL)
    @DisplayName("Check that number of languages in header corresponds to number of icons")
    void checkNumberOfLanguagesInHeaderCorrespondsToNumberOfIconsTest() {
        languagesPage.openLanguagesPage()
                .checkNumberOfLanguageIcons();
    }
}
