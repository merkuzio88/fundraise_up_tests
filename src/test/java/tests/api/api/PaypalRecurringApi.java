package tests.api.api;

import tests.api.models.RecurringRequestModel;
import tests.api.models.RecurringResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static tests.api.specs.Specs.*;

public class PaypalRecurringApi {

    public RecurringResponseModel recurringResponse(RecurringRequestModel recurringRequestModel) {
        return given(requestSpec)
                .body(recurringRequestModel)
                .contentType(JSON)
                .when()
                .post("https://api.tally.so/forms/3X5r6g/respond")
                .then()
                .spec(successfulResponseSpec)
                .extract().as(RecurringResponseModel.class);
    }
}
