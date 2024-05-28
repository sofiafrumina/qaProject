package ui;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import utils.VacanciesPage;
import utils.MainPage;

import static org.junit.Assert.assertTrue;
public class SovkomTest {
    VacanciesPage vacanciesPage = new VacanciesPage();
    MainPage mainPage = new MainPage();

    @Before
    public void setUp() {
        // Настройка конфигурации Selenide
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "D:/Downloads/chromedriver_win32/chromedriver.exe");
    }

    @Test
    public void testVacanciesFilter() {
        try {
        // 4.1 Перейти на страницу https://people.sovcombank.ru/
        // 4.2 Нажать на кнопку "Вакансии"
        mainPage.clickVacanciesButton();

        // 4.3 Выбрать в фильтре вакансий Город = "Москва", Компания = "Совкомбанк Технологии"
        vacanciesPage.selectCity("Москва");
        vacanciesPage.selectCompany("Совкомбанк Технологии");

        // 4.5 Проверить, что у всех найденных результатов указан город "Москва" и компания "Совкомбанк Технологии"
        for (SelenideElement vacancy : vacanciesPage.vacanciesList) {
            String vacancyText = vacancy.getText();
            assertTrue(vacancyText.contains("Москва") || vacancyText.contains("Вся Россия"));
            assertTrue(vacancyText.contains("Совкомбанк Технологии"));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


