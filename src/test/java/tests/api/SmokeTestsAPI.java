package tests.api;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestData;
import tests.api.api.AuthorizationApi;
import tests.api.api.PaypalRecurringApi;
import tests.api.api.SubscribeUpdatesApi;
import tests.api.models.*;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("api_tests")
public class SmokeTestsAPI extends TestBase {

    private final String unsuccessfulLoginMessage = "Invalid CSRF token";

    TestData testData = new TestData();
    AuthorizationApi authorizationApi = new AuthorizationApi();
    SubscribeUpdatesApi subscribeUpdatesApi = new SubscribeUpdatesApi();
    PaypalRecurringApi paypalRecurringApi = new PaypalRecurringApi();

    @Test
    @Severity(CRITICAL)
    @DisplayName("Making unsuccessful login request without CSRF token")
    void unsuccessfulLoginTest() {
        LoginRequestModel loginData = new LoginRequestModel()
                .withEmail(testData.randomEmail)
                .withPassword(testData.randomPassword);

        UnsuccessfulLoginResponseModel response = step("Send login request with random data", () ->
                authorizationApi.login(loginData));

        step("Check the message about invalid CSRF token from response", () -> {
            assertThat(response.getMessage())
                    .withFailMessage("Actual unsuccessful login message '%s' is not equals to expected '%s'",
                            response.getMessage(), unsuccessfulLoginMessage)
                    .isEqualTo(unsuccessfulLoginMessage);
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
            assertThat(response.getSubmissionId())
                    .withFailMessage("Actual response submissionId size is not equals to expected")
                    .hasSize(6);
            assertThat(response.getRespondentId())
                    .withFailMessage("Actual response respondentId size is not equals to expected")
                    .hasSize(6);
        });
    }
}
