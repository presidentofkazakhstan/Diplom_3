import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.PageObject.RegistrationAndLoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class UserLoginTest {
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
    @DisplayName("Login User With Login Button")
    public void loginUserWithLoginButton () {
        RegistrationAndLoginPage loginPage =  open(url, RegistrationAndLoginPage.class);
        loginPage.loginWithLoginButton("alibek1@mail.ru", "alibekalibek");
    }

    @Test
    @DisplayName("login User With Personal Area Button")
    public void loginUserWithPersonalAreaButton () {
        RegistrationAndLoginPage loginPage =  open(url, RegistrationAndLoginPage.class);
        loginPage.loginWithPersonalAreaButton("alibek1@mail.ru", "alibekalibek");
    }

    @Test
    @DisplayName("login User With Login Button In Registration Page")
    public void loginUserWithLoginButtonInRegistrationPage () {
        RegistrationAndLoginPage loginPage =  open(url, RegistrationAndLoginPage.class);
        loginPage.loginWithLoginButtonInRegistrationPage("alibek1@mail.ru", "alibekalibek");
    }



    @Test
    public void loginUserWithRestorePasswordButtonInRegistrationPage () {
        RegistrationAndLoginPage loginPage =  open(url, RegistrationAndLoginPage.class);
        loginPage.loginWithRestorePasswordButtonInRegistrationPage("alibek1@mail.ru", "alibekalibek");
    }


}
