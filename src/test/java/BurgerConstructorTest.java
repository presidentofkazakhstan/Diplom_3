import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import ru.yandex.praktikum.pageobject.RegistrationAndLoginPage;



import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
public class BurgerConstructorTest {
    final String url = "https://stellarburgers.nomoreparties.site/";

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Before
    public void setUp() {
        Configuration.browser="Chrome";
    }

    @Test
    @DisplayName("Click to Topping Tab")
    public void clickToppingTab () {
        RegistrationAndLoginPage burgerConstructor  =  open(url, RegistrationAndLoginPage.class);
        burgerConstructor.clickToTopping("Начинки");
    }

    @Test
    @DisplayName("Click to Bun Tab")
    public void clickBunTab () {
        RegistrationAndLoginPage burgerConstructor  =  open(url, RegistrationAndLoginPage.class);
        burgerConstructor.clickToBun("Булки");
    }

    @Test
    @DisplayName("Click to Sauce Tab")
    public void clickSaucesTab () {
        RegistrationAndLoginPage burgerConstructor  =  open(url, RegistrationAndLoginPage.class);
        burgerConstructor.clickToSauces("Соусы");
    }
}
