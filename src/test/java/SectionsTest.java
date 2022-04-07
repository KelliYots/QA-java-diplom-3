import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.objects.LoginPage;
import page.objects.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class SectionsTest {

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест перехода из одного раздела конструктора в другой")
    public void sectionsTest() {
        open(MainPage.BASE_URL, MainPage.class)
                .logInAccount();
        page(LoginPage.class)
                .sendEmailOnEnterPage("russianwarship@gofuck.yourself")
                .sendPassword("MakeLoveNotWar")
                .clickEnter();
        page(MainPage.class)
                .transitToStellar()
                .sousesClick()
                .bunsClick();
        final boolean sections = page(MainPage.class)
                .fillsClick();
        assertTrue(sections);
    }
}