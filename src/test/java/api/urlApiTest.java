package api;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.mail.sofiafrumina.qaProject.utils.TestDataLoader;

public class urlApiTest {

    @BeforeAll
    public static void setup() {
        // Настройка базового URL
        RestAssured.baseURI = "https://cleanuri.com/api";
    }

    @Test
    public void testShortenUrlPositive() throws IOException {
        // Загрузка списка URL из файла testData.txt
        List<String> urls = TestDataLoader.loadUrlsFromFile("src/test/resources/testData.txt");

        // Пример использования первого URL из списка для тестирования
        String urlToShorten = urls.get(0);
        given()
                .contentType("application/json")
                .body("{\"url\":\"" + urlToShorten + "\"}")
                .when()
                .post("/shorten")
                .then()
                .statusCode(200)
                .extract().response();

        // Добавьте дополнительные проверки или действия с другими URL, если необходимо
    }

    @Test
    public void testShortenUrlNegative() throws IOException {
        // Загрузка списка URL из файла testData.txt
        List<String> urls = TestDataLoader.loadUrlsFromFile("src/test/resources/testData.txt");

        // Пример использования первого URL из списка для тестирования отрицательного сценария
        String invalidUrl = "";
        given()
                .contentType("application/json")
                .body("{\"url\":\"" + invalidUrl + "\"}")
                .when()
                .post("/shorten")
                .then()
                .statusCode(400);

        // Добавьте дополнительные проверки или действия с другими URL, если необходимо
    }
}
