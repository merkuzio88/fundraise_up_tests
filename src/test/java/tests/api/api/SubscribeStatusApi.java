package tests.api.api;

import tests.api.models.SubscribeStatusRequestModel;
import tests.api.models.UnsuccessfulSubscribeResponseModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Specs.*;

public class SubscribeStatusApi {

    public UnsuccessfulSubscribeResponseModel subscribeStatus(SubscribeStatusRequestModel subscribeStatusRequestModel) {
        return given(requestSpec)
                .contentType("application/x-www-form-urlencoded")
                .formParam("email_otp_verify_flow", subscribeStatusRequestModel.getEmail_otp_verify_flow())
                .formParam("email", subscribeStatusRequestModel.getEmail())
                .formParam("captcha_error", subscribeStatusRequestModel.getCaptcha_error())
                .when()
                .post("https://status.fundraiseup.com/subscriptions/new-email")
                .then()
                .spec(subscribeStatusResponseSpec)
                .extract().as(UnsuccessfulSubscribeResponseModel.class);
    }
}
