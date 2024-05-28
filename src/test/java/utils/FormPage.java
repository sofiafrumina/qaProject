package utils;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class FormPage {
    public SelenideElement firstName = $x("//input[@id='firstName']");
    public SelenideElement lastName = $x("//input[@id='lastName']");
    public SelenideElement userEmail = $x("//input[@id='userEmail']");
    public SelenideElement gender = $x("//input[@id='gender-radio-2']");
    public SelenideElement userNumber= $x("//input[@id='userNumber']");
    public SelenideElement dateOfBirth = $x("//input[@id='dateOfBirthInput']");
    public SelenideElement subjects = $x("//div[@id='subjectsContainer']");
    public SelenideElement hobbies= $x("//input[@id='hobbies-checkbox-2']");
    public SelenideElement uploadPicture = $x("//input[@id='uploadPicture']");
    public SelenideElement currentAdress = $x("//textarea[@id='currentAddress']");
    public SelenideElement state = $x("//div[@id='state']");
    public SelenideElement city = $x("//div[@id='city']");
    public SelenideElement submitBtn = $x("//button[@id='submit']");
    public SelenideElement checkSubmit = $x("//div[@id='example-modal-sizes-title-lg']");

    // Добавляем элементы для проверки данных во всплывающем окне
    public SelenideElement modal = $x("//div[@class='modal-content']");
    public SelenideElement modalName = $x("//td[text()='Student Name']/following-sibling::td");
    public SelenideElement modalEmail = $x("//td[text()='Student Email']/following-sibling::td");
    public SelenideElement modalGender = $x("//td[text()='Gender']/following-sibling::td");
    public SelenideElement modalMobile = $x("//td[text()='Mobile']/following-sibling::td");
    public SelenideElement modalDateOfBirth = $x("//td[text()='DateOfBirth']/following-sibling::td");
    public SelenideElement modalSubjects = $x("//td[text()='Subjects']/following-sibling::td");
    public SelenideElement modalHobbies = $x("//td[text()='Hobbies']/following-sibling::td");
    public SelenideElement modalPicture = $x("//td[text()='Picture']/following-sibling::td");
    public SelenideElement modalAddress = $x("//td[text()='Address']/following-sibling::td");
    public SelenideElement modalStateCity = $x("//td[text()='State and City']/following-sibling::td");

}

