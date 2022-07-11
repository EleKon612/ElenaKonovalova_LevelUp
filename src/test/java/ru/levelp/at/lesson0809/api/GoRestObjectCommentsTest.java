package ru.levelp.at.lesson0809.api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;

public class GoRestObjectCommentsTest {

    private static final String BASE_URL = "https://gorest.co.in/public-api";
    private static final String COMMENTS = BASE_URL + "/comments";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .build()
                .header(new Header("Authorization",
                        "Bearer fb8bc7f65888c3dc5bdb863e609c4e7f5c7399b30c5e796906fd48fb6a99c515"));

        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();

        RestAssured.baseURI = BASE_URL;
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    @Test
    void getAllCommentsTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(COMMENTS)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(200))
                .body("meta.pagination.page", Matchers.equalTo(1))
                .body("meta.pagination.limit", Matchers.equalTo(10))
                .body("data.id", Matchers.not(emptyOrNullString()))
                .body("data.post_id", Matchers.not(emptyOrNullString()))
                .body("data.name", Matchers.not(emptyOrNullString()))
                .body("data.email", Matchers.not(emptyOrNullString()))
                .body("data.body", Matchers.not(emptyOrNullString()));
    }

    @Test
    void createCommentTest() {
        var faker = new Faker();
        var newPostId = new Random().nextInt(1800);
        var newName = faker.name().fullName();
        var newEmail = faker.internet().emailAddress();
        var newBody = faker.chuckNorris().fact();
        var newCommentRequest = CreateCommentsRequestData.builder()
                .post_id(newPostId)
                .name(newName)
                .email(newEmail)
                .body(newBody)
                .build();

        given()
                .body(newCommentRequest)
                .when()
                .post(COMMENTS)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.not(emptyOrNullString()))
                .body("data.post_id", Matchers.equalTo(newPostId))
                .body("data.name", Matchers.equalTo(newName))
                .body("data.email", Matchers.equalTo(newEmail))
                .body("data.body", Matchers.equalTo(newBody));
    }

    @Test
    void getRandomCommentTest() {
        var randomId = new Random().nextInt(1700);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get(COMMENTS + "/" + randomId)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(randomId))
                .body("data.post_id", Matchers.not(emptyOrNullString()))
                .body("data.name", Matchers.not(emptyOrNullString()))
                .body("data.email", Matchers.not(emptyOrNullString()))
                .body("data.body", Matchers.not(emptyOrNullString()));
    }

    @Test
    void updateRandomCommentTest() {
        var randomId = new Random().nextInt(1700);
        var faker = new Faker();
        var updatePostId = new Random().nextInt(1800);
        var updateName = faker.name().fullName();
        var updateEmail = faker.internet().emailAddress();
        var updateBody = faker.chuckNorris().fact();
        var updateCommentRequest = CreateCommentsRequestData.builder()
                .post_id(updatePostId)
                .name(updateName)
                .email(updateEmail)
                .body(updateBody)
                .build();

        given()
                .body(updateCommentRequest)
                .when()
                .put(COMMENTS+ "/" + randomId)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(randomId))
                .body("data.post_id", Matchers.equalTo(updatePostId))
                .body("data.name", Matchers.equalTo(updateName))
                .body("data.email", Matchers.equalTo(updateEmail))
                .body("data.body", Matchers.equalTo(updateBody));
    }

    @Test
    void deleteRandomCommentTest() {
        var randomId = new Random().nextInt(1700);

        given()
                .when()
                .delete(COMMENTS+ "/" + randomId)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(204))
                .body("meta", Matchers.equalTo(null))
                .body("data", Matchers.equalTo(null));
    }
}
