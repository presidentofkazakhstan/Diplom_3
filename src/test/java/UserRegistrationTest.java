import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.yandex.praktikum.PageObject.RegistrationAndLoginPage;
import ru.yandex.praktikum.PageObject.RandomGenerator;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

public class UserRegistrationTest {

    RandomGenerator randomGenerator = new RandomGenerator();

    @After
    public void tearDown() {
        closeWebDriver();
    }
    @Before
    public void setUp() {
        Configuration.browser="Chrome";
    }
    final String url = "https://stellarburgers.nomoreparties.site/";
    @Test
    @DisplayName("create User With Correct Credential")
    public void createUserWithCorrectCredential () {

        RegistrationAndLoginPage registrationPage =  open(url, RegistrationAndLoginPage.class);

        registrationPage.createUser(randomGenerator.userName, randomGenerator.userEmail, randomGenerator.userPassword);

        String json = "{" +
                "\"email\": \""+randomGenerator.userEmail+"\"," +
                "\"password\": \""+ randomGenerator.userPassword +"\"" +
                "}";;

                given()
                        .header("Content-type", "application/json")
                        .body(json)
                        .when()
                        .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                        .then().statusCode(200);;
    }

    @Test
    @DisplayName("create User With Incorrect Credential")
    public void createUserWithIncorrectCredential () {
        RegistrationAndLoginPage registrationPage =  open(url, RegistrationAndLoginPage.class);
        registrationPage.failedCreateUser(randomGenerator.userName, randomGenerator.userEmail, randomGenerator.userIncorrectPassword);
    }

}
