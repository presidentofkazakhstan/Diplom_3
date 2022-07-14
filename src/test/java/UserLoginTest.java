import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class UserLoginTest {
    final String url = "https://stellarburgers.nomoreparties.site/";

    UserCredentials credentials;
    RandomGenerator userGenerator;
    UserClient userClient;
    User user;
    String accessToken;

    @After
    public void tearDown() {
        closeWebDriver();
        userClient.delete(accessToken);
    }

    @Before
    public void setUp() {
        Configuration.browser="Chrome";
        userGenerator = new RandomGenerator();
        userClient = new UserClient();
        user = new User(userGenerator.userEmail, userGenerator.userPassword, userGenerator.userName);
        ValidatableResponse createUserResponse = userClient.create(user);
        accessToken = createUserResponse.extract().path("accessToken");
        credentials = new UserCredentials(user.getEmail(), user.getPassword());
    }

    @Test
    @DisplayName("Login User With Login Button")
    public void loginUserWithLoginButton () {
        RegistrationAndLoginPage loginPage =  open(url, RegistrationAndLoginPage.class);
        loginPage.loginWithLoginButton(credentials.getEmail(), credentials.getPassword());
    }

    @Test
    @DisplayName("login User With Personal Area Button")
    public void loginUserWithPersonalAreaButton () {
        RegistrationAndLoginPage loginPage =  open(url, RegistrationAndLoginPage.class);
        loginPage.loginWithPersonalAreaButton(credentials.getEmail(), credentials.getPassword());
    }

    @Test
    @DisplayName("login User With Login Button In Registration Page")
    public void loginUserWithLoginButtonInRegistrationPage () {
        RegistrationAndLoginPage loginPage =  open(url, RegistrationAndLoginPage.class);
        loginPage.loginWithLoginButtonInRegistrationPage(credentials.getEmail(), credentials.getPassword());
    }



    @Test
    public void loginUserWithRestorePasswordButtonInRegistrationPage () {
        RegistrationAndLoginPage loginPage =  open(url, RegistrationAndLoginPage.class);
        loginPage.loginWithRestorePasswordButtonInRegistrationPage(credentials.getEmail(), credentials.getPassword());
    }


}
