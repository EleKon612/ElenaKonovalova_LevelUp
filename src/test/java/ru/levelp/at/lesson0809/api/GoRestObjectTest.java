package ru.levelp.at.lesson0809.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GoRestObjectTest {

    private static final String BASE_URL = "https://gorest.co.in";
    private static final String SERVICE_BASE_PATH = " /public-api";
    private static final String USERS = SERVICE_BASE_PATH + "/users";
    private static final String POSTS = SERVICE_BASE_PATH + "/posts";
    private static final String COMMENTS = SERVICE_BASE_PATH + "/comments";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();

        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = SERVICE_BASE_PATH;
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    @Test
    void getUsersTest() {
        given()
                // .contentType("application/json")
                .contentType(ContentType.JSON)
                .when()
                .get(USERS)
                .then()
                .statusCode(200);
    }
}
