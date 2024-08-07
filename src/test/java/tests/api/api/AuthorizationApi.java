package tests.api.api;

import tests.api.models.LoginRequestModel;
import tests.api.models.UnsuccessfulResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static tests.api.specs.Specs.responseSpecWith403;
import static tests.api.specs.Specs.requestSpec;

public class AuthorizationApi {

    public UnsuccessfulResponseModel login(LoginRequestModel loginRequestModel) {
        return given(requestSpec)
                .body(loginRequestModel)
                .contentType(JSON)
                .when()
                .post("https://dashboard.fundraiseup.com/user/login")
                .then()
                .spec(responseSpecWith403)
                .extract().as(UnsuccessfulResponseModel.class);
    }
}
