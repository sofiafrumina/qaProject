package utils;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static SelenideElement vacanciesButton = $("//a[@href='/vacancies']");

    public static void clickVacanciesButton() {
        open("https://people.sovcombank.ru/vacancies");
        vacanciesButton.click();
    }
}
