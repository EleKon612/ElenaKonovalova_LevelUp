package ru.levelp.at.lesson0809.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;

public class GoRestServiceClientTest {

    private static final String BASE_URL = "https://gorest.co.in";

    private GoRestClient goRestClient;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = BASE_URL;

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;

        goRestClient = new GoRestClient();
    }
}
