package tests.api.api;

import tests.api.models.SubscribeProductsUpdatesRequestModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static tests.api.specs.Specs.*;

public class SubscribeUpdatesApi {

    public void subscribe(SubscribeProductsUpdatesRequestModel requestModel) {
        given(requestSpec)
                .body(requestModel)
                .contentType(JSON)
                .when()
                .post("https://forms.hscollectedforms.net/collected-forms/submit/form")
                .then()
                .spec(subscribeResponseSpecWith204);
    }
}
