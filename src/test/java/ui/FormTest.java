package ui;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import utils.FormPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class FormTest extends FormPage {
    @Before
    public void setUp() {
        // Настройка конфигурации Selenide
        Configuration.browserSize = String.valueOf(true);  // Открытие браузера в максимальном размере
        Configuration.browser = "chrome";     // Использование Chrome для тестов

        System.setProperty("webdriver.chrome.driver", "D:/Downloads/chromedriver_win32/chromedriver.exe");
    }
    @Test
    public void fillOutTheFormValid() {
        try {
            open("https://demoqa.com/automation-practice-form");
            firstName.setValue("Иван");
            lastName.setValue("Иванов");
            userEmail.setValue("ivanivanov@mail.ru");
            gender.click();
            userNumber.setValue("8765432191");
            subjects.setValue("English").pressEnter();
            hobbies.click();
            uploadPicture.uploadFile(new File("test/java/utils/nene.jpg"));
            currentAdress.setValue("Manhettan, filadelfia street, 64");
            state.click();
            state.$x(".//div[text()='NCR']").click();
            city.click();
            city.$x(".//div[text()='Delhi']").click();
            submitBtn.click();
            checkSubmit.shouldBe(Condition.visible);

            // Проверка данных во всплывающем окне
            modal.shouldBe(Condition.visible);
            modalName.shouldHave(Condition.text("Иван Иванов"));
            modalEmail.shouldHave(Condition.text("ivanivanov@mail.ru"));
            modalGender.shouldHave(Condition.text("Male"));
            modalMobile.shouldHave(Condition.text("8765432191"));
            modalSubjects.shouldHave(Condition.text("English"));
            modalHobbies.shouldHave(Condition.text("Reading"));
            modalPicture.shouldHave(Condition.text("nene.jpg"));
            modalAddress.shouldHave(Condition.text("Manhettan, filadelfia street, 64"));
            modalStateCity.shouldHave(Condition.text("NCR Delhi"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void fillOutTheFormNotValid(){
        try {
            open("https://demoqa.com/automation-practice-form");
            firstName.setValue("999");
            lastName.setValue("555");
            userEmail.setValue("ivanivanovmail.ru");
            gender.click();
            userNumber.setValue("87654321");
            subjects.setValue("English");
            subjects.pressEnter();
            hobbies.click();
            uploadPicture.uploadFile(new File("test/java/utils/nene.jpg"));
            currentAdress.setValue("Manhettan, filadelfia street, 64");
            state.click();
            state.pressEnter();
            city.click();
            city.pressEnter();
            submitBtn.click();
            checkSubmit.shouldBe(Condition.not(Condition.visible));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}