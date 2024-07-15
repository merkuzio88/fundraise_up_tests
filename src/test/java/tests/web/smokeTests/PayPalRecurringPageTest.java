package tests.web.smokeTests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PaypalRecurringPage;
import tests.web.TestBase;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("ui_tests")
public class PayPalRecurringPageTest extends TestBase {

    PaypalRecurringPage paypalRecurringPage = new PaypalRecurringPage();

    @Test
    @Severity(CRITICAL)
    @DisplayName("Check that successful PayPal recurring request message equals to expected")
    void checkSuccessfulPaypalRecurringRequestMessageTest() {
        paypalRecurringPage.openPaypalRecurringPage()
                .fillRandomDataAndCheckPaypalRecurringRequestMessage();
    }
}
