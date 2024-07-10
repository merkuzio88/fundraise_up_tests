package tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;

public class Specs {

    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .log().all();

    public static ResponseSpecification responseSpecWith403 = new ResponseSpecBuilder()
            .expectStatusCode(403)
            .log(ALL)
            .build();

    public static ResponseSpecification subscribeResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(ALL)
            .build();

    public static ResponseSpecification successfulResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

    public static ResponseSpecification subscribeStatusResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(ALL)
            .build();
}
