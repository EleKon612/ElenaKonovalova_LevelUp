package ru.levelp.at.lesson1011.cicd;

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
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0809.api.CreateCommentsRequestData;
import ru.levelp.at.lesson0809.api.CreatePostsRequestData;
import ru.levelp.at.lesson0809.api.CreateUsersRequestData;

public class GoRestObjectAllureTest {

    private static final String BASE_URL = "https://gorest.co.in/public-api";
    private static final String USERS = BASE_URL + "/users";
    private static final String POSTS = BASE_URL + "/posts";
    private static final String COMMENTS = BASE_URL + "/comments";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeSuite
    public void beforeSuite() {
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
                .put(USERS + "/" + randomId)
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
                .delete(USERS + "/" + randomId)
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
                .postId(newPostId)
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
                .postId(updatePostId)
                .name(updateName)
                .email(updateEmail)
                .body(updateBody)
                .build();

        given()
                .body(updateCommentRequest)
                .when()
                .put(COMMENTS + "/" + randomId)
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
                .delete(COMMENTS + "/" + randomId)
                .then()
                .statusCode(200)
                .body("code", Matchers.equalTo(204))
                .body("meta", Matchers.equalTo(null))
                .body("data", Matchers.equalTo(null));
    }
}
