package page.objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

@Getter
public class RegisterPage {
    @FindBy(xpath = ".//input[@type='text']")
    private SelenideElement namePlace;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailPlace;

    @FindBy(xpath = ".//input[@name='Пароль']")
    private SelenideElement password;

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(xpath = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement registrationError;

    @Step("Ввод имени")
    public RegisterPage setName(String name){
        namePlace.setValue(name);
        return this;
    }

    @Step("Ввод email")
    public RegisterPage sendEmail(String email){
        emailPlace.setValue(email);
        return this;
    }

    @Step("Ввод пароля")
    public RegisterPage sendPassword(String pass){
        password.setValue(pass);
        return this;
    }

    @Step("Нажать на кнопку регистрации")
    public RegisterPage clickRegister(){
        registrationButton.shouldBe(enabled).click();
        return this;
    }

    @Step("Сообщение об ошибке регстрации видна")
    public boolean registrationError(){
        return registrationError.is(visible);
    }
}