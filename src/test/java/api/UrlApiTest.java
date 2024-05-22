package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import utils.TestDataLoader;

public class UrlApiTest {

    private static TestDataLoader testDataLoader = new TestDataLoader();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://cleanuri.com/api/v1";
    }

    @Test
    public void testCreateShortUrlWithValidUrl() throws IOException {
        List<String> validUrls = null;
        try {
            validUrls = testDataLoader.loadUrlsFromFile("C:\\Users\\sofia\\IdeaProjects\\qaProject\\src\\test\\resources\\data_valid_urls.json");
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке валидных URL из файла: " + e.getMessage());
            throw e;
        }

        for (String validUrl : validUrls) {
            try {
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("url", validUrl) // URL кодирование будет обработано RestAssured
                        .when()
                        .post("/shorten")
                        .then()
                        .log().body() // Логируем весь ответ
                        .statusCode(200)
                        .body("result_url", notNullValue());
            } catch (Exception e) {
                System.err.println("Ошибка при отправке запроса для URL: " + validUrl);
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCreateShortUrlWithInvalidUrl() throws IOException {
        List<String> invalidUrls;
        try {
            invalidUrls = testDataLoader.loadUrlsFromFile("C:\\Users\\sofia\\IdeaProjects\\qaProject\\src\\test\\resources\\data_invalid_urls.json");
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке невалидных URL из файла: " + e.getMessage());
            throw e;
        }

        for (String invalidUrl : invalidUrls) {
            try {
                given()
                        .log().all() // Логируем весь запрос
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("url", invalidUrl)
                        .when()
                        .post("/shorten")
                        .then()
                        .log().all() // Логируем весь ответ
                        .statusCode(400);
            } catch (Exception e) {
                System.err.println("Ошибка при отправке запроса для URL: " + invalidUrl);
                e.printStackTrace();
            }
        }
    }
}
