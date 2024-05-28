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
}
