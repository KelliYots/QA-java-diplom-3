package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountPage {

    @FindBy(xpath = ".//button[@type='button']")
    private SelenideElement exitButton;

    @Step("Клик по кнопке выход")
    public void exitButtonClick(){
        exitButton.shouldBe(Condition.enabled);
        exitButton.click();
    }
}