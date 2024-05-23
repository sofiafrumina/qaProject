package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RandomUserResponse;
import utils.User;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomUserApiTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://randomuser.me/api";
    }

    @Test
    public void testGetUserByGender() {
        Response response = given()
                .queryParam("gender", "female")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response();

        RandomUserResponse randomUserResponse = response.as(RandomUserResponse.class);
        List<User> users = randomUserResponse.getResults();

        users.forEach(user -> System.out.println("Gender: " + user.getGender()));

        assertThat(users).allMatch(user -> "female".equals(user.getGender()));
    }

    @Test
    public void testGetSpecificNumberOfUsers() {
        int expectedNumberOfUsers = 5;
        Response response = given()
                .queryParam("results", expectedNumberOfUsers)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response();

        RandomUserResponse randomUserResponse = response.as(RandomUserResponse.class);
        List<User> users = randomUserResponse.getResults();

        users.forEach(user -> System.out.println("User: " + user));

        assertThat(users).hasSize(expectedNumberOfUsers);
    }

    @Test
    public void testFilterByNationality() {
        String[] nationalities = {"us", "gb"};
        Response response = given()
                .queryParam("nat", String.join(",", nationalities))
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response();

        RandomUserResponse randomUserResponse = response.as(RandomUserResponse.class);
        List<User> users = randomUserResponse.getResults();

        users.forEach(user -> System.out.println("Nationality: " + user.getNat()));

        assertThat(users).allMatch(user -> {
            String nat = user.getNat();
            return nat.equalsIgnoreCase("US") || nat.equalsIgnoreCase("GB");
        });
    }
    @Test
    public void testInvalidQueryParameter() {
        Response response = given()
                .log().all()
                .queryParam("unknownParam", "value")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200) // Assuming the service ignores unknown parameters
                .extract().response();

        // Additional assertions can be added based on the actual response
        assertThat(response.getBody().asString()).contains("results");
    }

    @Test
    public void testInvalidParameterValue() {
        Response response = given()
                .log().all()
                .queryParam("gender", "alien")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200) // Assuming the service ignores invalid values
                .extract().response();

        // Additional assertions can be added based on the actual response
        assertThat(response.getBody().asString()).contains("results");
    }

    @Test
    public void testMissingRequiredParameters() {
        // Assuming no required parameters are needed to get a basic response
        Response response = given()
                .log().all()
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        // Additional assertions can be added based on the actual response
        assertThat(response.getBody().asString()).contains("results");
    }
}