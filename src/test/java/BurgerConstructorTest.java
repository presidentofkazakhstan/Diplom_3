import com.codeborne.selenide.Configuration;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import ru.yandex.praktikum.PageObject.BurgerConstructorPage;



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
        BurgerConstructorPage burgerConstructorPage  =  open(url, BurgerConstructorPage.class);
        burgerConstructorPage.clickToTopping("Начинки");
    }

    @Test
    @DisplayName("Click to Bun Tab")
    public void clickBunTab () {
        BurgerConstructorPage burgerConstructorPage  =  open(url, BurgerConstructorPage.class);
        burgerConstructorPage.clickToBun("Булки");
    }

    @Test
    @DisplayName("Click to Sauce Tab")
    public void clickSaucesTab () {
        BurgerConstructorPage burgerConstructorPage  =  open(url, BurgerConstructorPage.class);
        burgerConstructorPage.clickToSauces("Соусы");
    }
}
