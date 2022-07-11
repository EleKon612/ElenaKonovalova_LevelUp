package ru.levelp.at.lesson0809.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;

import java.security.SecureRandom;
import java.util.Arrays;
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
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoRestObjectUsersTest {

    private static final String BASE_URL = "https://gorest.co.in/public-api";
    private static final String USERS = BASE_URL + "/users";

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
                .statusCode(200)
                .body("code", Matchers.equalTo(200))
                .body("meta.pagination.page", Matchers.equalTo(1))
                .body("meta.pagination.limit", Matchers.equalTo(10))
                .body("data.id", Matchers.not(emptyOrNullString()))
                .body("data.name", Matchers.not(emptyOrNullString()))
                .body("data.email", Matchers.not(emptyOrNullString()))
                .body("data.gender", Matchers.not(emptyOrNullString()))
                .body("data.status", Matchers.not(emptyOrNullString()));
    }

    @Test
    void createUserTest() {
        var faker = new Faker();
        var newName = faker.name().fullName();
        var newGender = faker.demographic().sex().toLowerCase(Locale.ROOT);
        var newEmail = faker.internet().emailAddress();
        var random = new SecureRandom();
        var statusList = Arrays.asList("active", "inactive");
        var newRandomStatus = statusList.get(random.nextInt(statusList.size()));
        var personRequest = CreateUsersRequestData.builder()
                .name(newName)
                .gender(newGender)
                .email(newEmail)
                .status(newRandomStatus)
                .build();

        given()
                .body(personRequest)
                .when()
                .post(USERS)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.not(emptyOrNullString()))
                .body("data.name", Matchers.equalTo(newName))
                .body("data.email", Matchers.equalTo(newEmail))
                .body("data.gender", Matchers.equalTo(newGender))
                .body("data.status", Matchers.equalTo(newRandomStatus));
    }

    @Test
    void getRandomUserTest() {
        var randomId = new Random().nextInt(3800);

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
        var randomId = new Random().nextInt(3800);
        var faker = new Faker();
        var updatedName = faker.name().fullName();
        var updatedGender = faker.demographic().sex().toLowerCase(Locale.ROOT);
        var updatedEmail = faker.internet().emailAddress();
        var random = new SecureRandom();
        var statusList = Arrays.asList("active", "inactive");
        var updatedRandomStatus = statusList.get(random.nextInt(statusList.size()));
        var personRequest = CreateUsersRequestData.builder()
                .name(updatedName)
                .gender(updatedGender)
                .email(updatedEmail)
                .status(updatedRandomStatus)
                .build();

        given()
                .body(personRequest)
                .when()
                .put(USERS+ "/" + randomId)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(randomId))
                .body("data.name", Matchers.equalTo(updatedName))
                .body("data.gender", Matchers.equalTo(updatedGender))
                .body("data.email", Matchers.equalTo(updatedEmail))
                .body("data.status", Matchers.equalTo(updatedRandomStatus));
    }

    @Test
    void deleteRandomUserTest() {
        var randomId = new Random().nextInt(3800);

        given()
                .when()
                .delete(USERS+ "/" + randomId)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(204))
                .body("meta", Matchers.equalTo(null))
                .body("data", Matchers.equalTo(null));
    }
}
