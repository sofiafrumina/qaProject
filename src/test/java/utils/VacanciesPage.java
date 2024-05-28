package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class VacanciesPage {
    // Элементы страницы
    public SelenideElement cityFilter = $x("//input[@id=1]");
    public SelenideElement companyFilter = $x("//div[contains(@class, 'v-list-item__title') and contains(text(), 'Совкомбанк Технологии')]");
    public ElementsCollection vacanciesList = $$("a[href*='/vacancies/']");

    // Метод для выбора города
    public void selectCity(String city) {
        cityFilter.selectOption(city);
    }

    // Метод для выбора компании
    public void selectCompany(String company) {
        companyFilter.selectOption(company);
    }
}

