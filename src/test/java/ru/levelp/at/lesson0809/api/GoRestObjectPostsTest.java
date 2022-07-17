package ru.levelp.at.lesson0809.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Random;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GoRestObjectPostsTest {

    private static final String BASE_URL = "https://gorest.co.in/public-api";
    private static final String POSTS = BASE_URL + "/posts";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeSuite
    public void beforeSuite() {
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
    void getAllPostsTest() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(POSTS)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(200))
                .body("meta.pagination.page", Matchers.equalTo(1))
                .body("meta.pagination.limit", Matchers.equalTo(10))
                .body("data.id", Matchers.not(emptyOrNullString()))
                .body("data.user_id", Matchers.not(emptyOrNullString()))
                .body("data.title", Matchers.not(emptyOrNullString()))
                .body("data.body", Matchers.not(emptyOrNullString()));
    }

    @Test
    void createPostTest() {
        var faker = new Faker();
        var newUserId = new Random().nextInt(3800);
        var newTitle = faker.shakespeare().asYouLikeItQuote();
        var newBody = faker.chuckNorris().fact();
        var newPostRequest = CreatePostsRequestData.builder()
                .userId(newUserId)
                .title(newTitle)
                .body(newBody)
                .build();

        given()
                .body(newPostRequest)
                .when()
                .post(POSTS)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.not(emptyOrNullString()))
                .body("data.user_id", Matchers.equalTo(newUserId))
                .body("data.title", Matchers.equalTo(newTitle))
                .body("data.body", Matchers.equalTo(newBody));
    }

    @Test
    void getRandomPostTest() {
        var randomId = new Random().nextInt(1800);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get(POSTS + "/" + randomId)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(randomId))
                .body("data.user_id", Matchers.not(emptyOrNullString()))
                .body("data.title", Matchers.not(emptyOrNullString()))
                .body("data.body", Matchers.not(emptyOrNullString()));
    }

    @Test
    void updateRandomPostTest() {
        var randomId = new Random().nextInt(1800);
        var faker = new Faker();
        var newUserId = new Random().nextInt(3800);
        var updatedTitle = faker.book().title();
        var updatedBody = faker.harryPotter().quote();
        var updatePostRequest = CreatePostsRequestData.builder()
                .userId(newUserId)
                .title(updatedTitle)
                .body(updatedBody)
                .build();

        given()
                .body(updatePostRequest)
                .when()
                .put(POSTS + "/" + randomId)
                .then()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(randomId))
                .body("data.user_id", Matchers.equalTo(newUserId))
                .body("data.title", Matchers.equalTo(updatedTitle))
                .body("data.body", Matchers.equalTo(updatedBody));
    }

    @Test
    void deleteRandomPostTest() {
        var randomId = new Random().nextInt(1800);

        given()
                .when()
                .delete(POSTS + "/" + randomId)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(204))
                .body("meta", Matchers.equalTo(null))
                .body("data", Matchers.equalTo(null));
    }
}
