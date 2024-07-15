package tests.web.smokeTests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import tests.web.TestBase;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Tag("ui_tests")
public class LoginPageTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Check error message with unsuccessful login attempt")
    void checkErrorMessageWithUnsuccessfulLoginAttemptTest() {
        loginPage.openLoginPage()
                .fillRandomDataAndSubmitAttempt()
                .checkErrorMessageWithUnsuccessfulLogin();
    }
}
