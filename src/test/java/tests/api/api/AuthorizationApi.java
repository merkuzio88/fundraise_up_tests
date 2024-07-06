package tests.api.api;

import tests.api.models.LoginRequestModel;
import tests.api.models.UnsuccessfulLoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static tests.api.specs.Specs.loginResponseSpecWith403;
import static tests.api.specs.Specs.requestSpec;

public class AuthorizationApi {

    public UnsuccessfulLoginResponseModel login(LoginRequestModel loginRequestModel) {
        return given(requestSpec)
                .body(loginRequestModel)
                .contentType(JSON)
                .when()
                .post("https://dashboard.fundraiseup.com/user/login")
                .then()
                .spec(loginResponseSpecWith403)
                .extract().as(UnsuccessfulLoginResponseModel.class);
    }
}
