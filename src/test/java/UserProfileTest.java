import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.*;

public class UserProfileTest {
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
    @DisplayName("check User email in Profile")
    public void checkUserProfile () {
        UserProfilePage userProfile =  open(url, UserProfilePage.class);
        userProfile.checkUserProfile(credentials.getEmail(), credentials.getPassword());
    }

    @Test
    @DisplayName("go To Burger Constructor")
    public void goToBurgerConstructor () {
        UserProfilePage userProfile =  open(url, UserProfilePage.class);
        userProfile.goToBurgerConstructor(credentials.getEmail(), credentials.getPassword());
    }

    @Test
    @DisplayName("go To Burger Constructor With Logo")
    public void goToBurgerConstructorWithLogo () {
        UserProfilePage userProfile =  open(url, UserProfilePage.class);
        userProfile.goToBurgerConstructorWithLogo(credentials.getEmail(), credentials.getPassword());
    }

    @Test
    @DisplayName("Exit In Profile")
    public void exitInProfile () {
        UserProfilePage userProfile =  open(url, UserProfilePage.class);
        userProfile.exitProfile(credentials.getEmail(), credentials.getPassword());
    }
}
