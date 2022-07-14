import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.yandex.praktikum.pageobject.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserRegistrationTest {

    final String url = "https://stellarburgers.nomoreparties.site/";
    UserCredentials credentials;
    RandomGenerator userGenerator;
    UserClient userClient;
    User user;
    String accessToken;

    @After
    public void tearDown() {
        closeWebDriver();
        if(accessToken!=null)
        userClient.delete(accessToken);
    }
    @Before
    public void setUp() {
        Configuration.browser="Chrome";
        userGenerator = new RandomGenerator();
        userClient = new UserClient();
        user = new User(userGenerator.userEmail, userGenerator.userPassword, userGenerator.userName);
        credentials = new UserCredentials(user.getEmail(), user.getPassword());
    }

    @Test
    @DisplayName("create User With Correct Credential")
    public void createUserWithCorrectCredential () {
        RegistrationAndLoginPage registrationPage =  open(url, RegistrationAndLoginPage.class);
        registrationPage.createUser( userGenerator.userName , userGenerator.userEmail, userGenerator.userPassword);
        ValidatableResponse loginResponse = userClient.login(credentials);
        accessToken = loginResponse.extract().path("accessToken");
        int statusCode = loginResponse.extract().statusCode();
        boolean isSuccess = loginResponse.extract().path("success");
        assertThat("User cannot create", statusCode, equalTo(SC_OK));
        assertThat("User cannot create", isSuccess, is(not(false)));
    }

    @Test
    @DisplayName("create User With Incorrect Credential")
    public void createUserWithIncorrectCredential () {
        RegistrationAndLoginPage registrationPage =  open(url, RegistrationAndLoginPage.class);
        registrationPage.failedCreateUser(userGenerator.userName, userGenerator.userEmail, userGenerator.userIncorrectPassword);
        ValidatableResponse loginResponse = userClient.login(credentials);
        accessToken = loginResponse.extract().path("accessToken");
        int statusCode = loginResponse.extract().statusCode();
        boolean isSuccess = loginResponse.extract().path("success");
        assertThat("User cannot create", statusCode, equalTo(SC_UNAUTHORIZED));
        assertThat("User cannot create", isSuccess, is((false)));
    }

}
