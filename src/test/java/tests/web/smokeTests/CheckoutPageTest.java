package tests.web.smokeTests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CheckoutPage;
import tests.web.TestBase;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("ui_tests")
public class CheckoutPageTest extends TestBase {

    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    @Severity(CRITICAL)
    @DisplayName("Check opening checkout widget window")
    void checkOpeningCheckoutWidgetWindowTest() {
        checkoutPage.openCheckoutPage()
                .checkWidgetWindow();
    }
}
