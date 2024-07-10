package tests.api.api;

import tests.api.models.ContactFieldsModel;
import tests.api.models.UnsuccessfulResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static tests.api.specs.Specs.*;

public class PasswordResetApi {

    public UnsuccessfulResponseModel resetPassword(ContactFieldsModel contactFieldsModel) {
        return given(requestSpec)
                .body(contactFieldsModel)
                .contentType(JSON)
                .when()
                .post("https://dashboard.fundraiseup.com/user/restore")
                .then()
                .spec(responseSpecWith403)
                .extract().as(UnsuccessfulResponseModel.class);
    }
}
