package tests.api;

import io.qameta.allure.Severity;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestData;
import tests.api.api.*;
import tests.api.models.*;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("api_tests")
public class SmokeTestsAPI extends TestBase {

    private final String unsuccessfulRequestMessage = "Invalid CSRF token";
    private final String unsuccessfulSubscribeMessage = "This endpoint is only available via the UI";

    TestData testData = new TestData();
    AuthorizationApi authorizationApi = new AuthorizationApi();
    SubscribeUpdatesApi subscribeUpdatesApi = new SubscribeUpdatesApi();
    PaypalRecurringApi paypalRecurringApi = new PaypalRecurringApi();
    SubscribeStatusApi subscribeStatusApi = new SubscribeStatusApi();
    PasswordResetApi passwordResetApi = new PasswordResetApi();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Making unsuccessful login request without CSRF token")
    void unsuccessfulLoginTest() {
        LoginRequestModel loginData = new LoginRequestModel()
                .withEmail(testData.randomEmail)
                .withPassword(testData.randomPassword);

        UnsuccessfulResponseModel response = step("Send login request with random data", () ->
                authorizationApi.login(loginData));

        step("Check the message about invalid CSRF token from response", () -> {
            assertThat(response.getMessage())
                    .withFailMessage("Actual unsuccessful login message '%s' is not equals to expected '%s'",
                            response.getMessage(), unsuccessfulRequestMessage)
                    .isEqualTo(unsuccessfulRequestMessage);
        });
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Making request to subscribe product updates")
    void subscribeToProductUpdatesTest() {
        SubscribeProductsUpdatesRequestModel subscribeData = new SubscribeProductsUpdatesRequestModel()
                .withPortalId(testData.randomPortalId);
        subscribeData.setContactFields(new ContactFieldsModel(testData.randomEmail));

        step("Send subscribe product updates request with random data and check status code", () ->
                subscribeUpdatesApi.subscribe(subscribeData));
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Making request to PayPal recurring")
    void paypalRecurringRequestTest() {
        Map<String, String> responses = new HashMap<>();
        responses.put(testData.randomUuid, testData.randomString);
        RecurringRequestModel requestModel = new RecurringRequestModel()
                .withSessionUuid(testData.randomUuid)
                .withRespondentUuid(testData.randomUuid)
                .withResponses(responses)
                .withCompleted(true);

        RecurringResponseModel response = step("Send Paypal recurring request with random data", () ->
                paypalRecurringApi.recurringResponse(requestModel));

        step("Check required fields in response body", () -> {
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(response.getSubmissionId())
                    .withFailMessage("Actual response submissionId size is not equals to expected")
                    .hasSize(6);
            softAssertions.assertThat(response.getRespondentId())
                    .withFailMessage("Actual response respondentId size is not equals to expected")
                    .hasSize(6);
            softAssertions.assertAll();
        });
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Making unsuccessful subscribe status request")
    void unsuccessfulSubscribeStatusTest() {
        SubscribeStatusRequestModel requestModel = new SubscribeStatusRequestModel()
                .withEmail_otp_verify_flow(false)
                .withEmail(testData.randomEmail)
                .withCaptcha_error(false);

        UnsuccessfulSubscribeResponseModel response = step("Send subscribe status request with random data", () ->
                subscribeStatusApi.subscribeStatus(requestModel));

        step("Check the message about unavailable endpoint from response", () -> {
            assertThat(response.getError())
                    .withFailMessage("Actual unsuccessful subscribe message '%s' is not equals to expected '%s'",
                            response.getError(), unsuccessfulSubscribeMessage)
                    .isEqualTo(unsuccessfulSubscribeMessage);
        });
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Making unsuccessful password reset request")
    void successfulPasswordResetTest() {
        ContactFieldsModel contactFieldsModel = new ContactFieldsModel()
                .withEmail(testData.randomEmail);

        UnsuccessfulResponseModel response = step("Send reset password request with random data", () ->
                passwordResetApi.resetPassword(contactFieldsModel));

        step("Check the message about invalid CSRF token from response", () -> {
            assertThat(response.getMessage())
                    .withFailMessage("Actual unsuccessful reset password message '%s' is not equals to expected '%s'",
                            response.getMessage(), unsuccessfulRequestMessage)
                    .isEqualTo(unsuccessfulRequestMessage);
        });
    }
}
