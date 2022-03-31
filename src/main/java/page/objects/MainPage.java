package page.objects;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

@Getter
public class MainPage {

    public static String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @FindBy(xpath = ".//span[text()='Начинки']")
    private SelenideElement fills;

    @FindBy(xpath = ".//p[text()='Мясо бессмертных моллюсков Protostomia']")
    private SelenideElement fillsMeat;

    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private SelenideElement orderButton;

    @FindBy(xpath = ".//p[text()='Конструктор']")
    private SelenideElement constructor;

    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private SelenideElement logInAccount;

    @FindBy(xpath = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccount;

    @FindBy(xpath = ".//a[@href='/']")
    private SelenideElement stellar;

    @FindBy(xpath = ".//span[text()='Соусы']")
    private SelenideElement souses;

    @FindBy(xpath = ".//span[text()='Булки']")
    private SelenideElement buns;

    @Step("Кнопка заказа видна")
    public boolean isOrderButtonVisible() {
        orderButton.shouldBe(enabled);
        return orderButton.is(visible);
    }

    @Step("Клик на кнопку Личный кабинет")
    public MainPage clickPersonalAccount() {
        personalAccount.shouldBe(enabled).click();
        return this;
    }

    @Step("Вход в аккаунт")
    public MainPage logInAccount() {
        logInAccount.shouldBe(enabled);
        logInAccount.click();
        return this;
    }

    @Step("Переход в конструктор")
    public MainPage transitToConstructor() {
        constructor.shouldBe(enabled);
        constructor.click();
        return this;
    }

    @Step("Входа по кнопке Стеллар")
    public MainPage transitToStellar() {
        stellar.shouldBe(enabled);
        stellar.click();
        return this;
    }

    @Step("Клик на соусы")
    public MainPage sousesClick() {
        souses.shouldBe(enabled);
        souses.click();
        return this;
    }

    @Step("Клик на булки")
    public MainPage bunsClick() {
        buns.shouldBe(enabled);
        buns.click();
        return this;
    }

    @Step("Клик на начинки")
    public boolean fillsClick() {
        fills.shouldBe(enabled);
        fills.click();
        return fillsMeat.is(visible);
    }
}