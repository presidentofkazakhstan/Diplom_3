import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.PageObject.RegistrationAndLoginPage;
import ru.yandex.praktikum.PageObject.UserProfilePage;
public class UserProfileTest {
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
    @DisplayName("check User email in Profile")
    public void checkUserProfile () {
        UserProfilePage userProfile =  open(url, UserProfilePage.class);
        userProfile.checkUserProfile("alibek1@mail.ru", "alibekalibek");
    }

    @Test
    @DisplayName("go To Burger Constructor")
    public void goToBurgerConstructor () {
        UserProfilePage userProfile =  open(url, UserProfilePage.class);
        userProfile.goToBurgerConstructor("alibek1@mail.ru", "alibekalibek");
    }

    @Test
    @DisplayName("go To Burger Constructor With Logo")
    public void goToBurgerConstructorWithLogo () {
        UserProfilePage userProfile =  open(url, UserProfilePage.class);
        userProfile.goToBurgerConstructorWithLogo("alibek1@mail.ru", "alibekalibek");
    }


    @Test
    @DisplayName("Exit In Profile")
    public void exitInProfile () {
        UserProfilePage userProfile =  open(url, UserProfilePage.class);
        userProfile.exitProfile("alibek1@mail.ru", "alibekalibek");
    }



}
