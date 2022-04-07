package page.objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    public static String loginPageUrl = "https://stellarburgers.nomoreparties.site/login";


    @FindBy(xpath = ".//a[@href='/register']")
    private SelenideElement registrationButtonLink;

    @FindBy(xpath = ".//input[@name='name']")
    private SelenideElement emailPlaceOnEnterPage;

    @FindBy(xpath = ".//input[@name='Пароль']")
    private SelenideElement password;

    @FindBy(xpath = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    @FindBy(xpath = ".//a[@href='/forgot-password']")
    private SelenideElement forgotPasswordLink;

    @FindBy(className = "Auth_link__1fOlj")
    private SelenideElement logInRegistrationForm;

    public void logInRegistrationFormByLink() {
        registrationButtonLink.shouldBe(enabled);
        registrationButtonLink.click();
    }

    @Step("Ввод email на страинце входа в аккаунт")
    public LoginPage sendEmailOnEnterPage(String email) {
        emailPlaceOnEnterPage.setValue(email);
        return this;
    }

    @Step("Ввод пароля")
    public LoginPage sendPassword(String pass) {
        password.setValue(pass);
        return this;
    }

    @Step("Нажать enter")
    public void clickEnter() {
        enterButton.shouldBe(enabled);
        enterButton.click();
    }

    @Step("Клик по ссылке \"Забыл пароль\"")
    public LoginPage logInForgotPasswordLink() {
        forgotPasswordLink.shouldBe(enabled);
        forgotPasswordLink.click();
        return this;
    }

    @Step("Вход через форму регистрации")
    public LoginPage logInRegistrationForm() {
        logInRegistrationForm.shouldBe(enabled);
        logInRegistrationForm.click();
        return this;
    }

    @Step("Проверка, что кнопка входа видна")
    public boolean getEnter() {
        enterButton.shouldBe(enabled);
        return enterButton.is(visible);
    }
}