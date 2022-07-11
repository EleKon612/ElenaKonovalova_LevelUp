package ru.levelp.at.lesson0809.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.ObjectUtils;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoRestObjectTest {

    private static final String BASE_URL = "https://gorest.co.in/public-api";
    private static final String USERS = BASE_URL + "/users";
    private static final String POSTS = BASE_URL + "/posts";
    private static final String COMMENTS = BASE_URL + "/comments";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        //OAuth2Scheme auth = new OAuth2Scheme();
        //auth.setAccessToken("fb8bc7f65888c3dc5bdb863e609c4e7f5c7399b30c5e796906fd48fb6a99c515");
        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                //.setAuth(new BasicAuthScheme())
                //.setAuth(auth)
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
    void getAllUsersTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(USERS)
                .then()
                .statusCode(200);
    }

    @Test
    void createUserTest() {
        var faker = new Faker();
        var personRequest = CreatePersonRequestData.builder()
                .name(faker.name().fullName())
                .gender(faker.demographic().sex().toLowerCase(Locale.ROOT))
                .email(faker.internet().emailAddress())
                .status("active")
                .build();

        given()
                .body(personRequest)
                .when()
                .post(USERS)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.not(emptyOrNullString()));
    }

    @Test
    void getRandomUserTest() {
        var randomId = new Random().nextInt(5000);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get(USERS + "/" + randomId)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(randomId))
                .body("data.name", Matchers.not(emptyOrNullString()))
                .body("data.email", Matchers.not(emptyOrNullString()))
                .body("data.gender", Matchers.not(emptyOrNullString()))
                .body("data.status", Matchers.not(emptyOrNullString()));
    }

    @Test
    void updateRandomUserTest() {
        var randomId = new Random().nextInt(5000);
        var faker = new Faker();
        var updatedName = faker.name().fullName();
        var updatedEmail = faker.internet().emailAddress();
        var personRequest = CreatePersonRequestData.builder()
                .name(updatedName)
                .gender(faker.demographic().sex().toLowerCase(Locale.ROOT))
                .email(updatedEmail)
                .status("inactive")
                .build();

        given()
                .body(personRequest)
                .when()
                .put(USERS+ "/" + randomId)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(randomId))
                .body("data.name", Matchers.equalTo(updatedName))
                .body("data.email", Matchers.equalTo(updatedEmail));
    }

    @Test
    void deleteRandomUserTest() {
        var randomId = new Random().nextInt(5000);

        given()
                .when()
                .delete(USERS+ "/" + randomId)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(204))
                .body("meta", Matchers.equalTo(null))
                .body("data", Matchers.equalTo(null));
    }

    @Test
    void getAllPostsTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(POSTS)
                .then()
                .statusCode(200);
    }


}
