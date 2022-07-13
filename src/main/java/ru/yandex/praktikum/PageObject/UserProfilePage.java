package ru.yandex.praktikum.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.Assert.assertEquals;

public class UserProfilePage  {

    @FindBy(how = How.LINK_TEXT,using = "Личный Кабинет")
    private SelenideElement personalAreaButton;

    @FindBy(how = How.LINK_TEXT,using = "Конструктор")
    private SelenideElement burgerConstructor;

    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    private SelenideElement emailField;

    @FindBy(how = How.CSS,using = "[name=Пароль]")
    private SelenideElement passwordField;

    @FindBy(how = How.CSS,using = "[viewBox='0 0 290 50']")
    private SelenideElement logo;
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement enterAuthorizationButton;

    @FindBy(how = How.CSS,using = "[name=name]")
    private SelenideElement EmailFieldInProfile;

    @FindBy(how = How.XPATH,using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    public void clickEnterAuthorizationButton() {
        enterAuthorizationButton.click();
    }

    public void clickPersonalAreaButton() {
        personalAreaButton.click();
    }

    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    public void clickBurgerConstructorButton() {
        burgerConstructor.click();
    }
    public void clickLogoButton() {
        logo.click();
    }

    public void clickExitButton() {
        exitButton.click();
    }


    public void checkUserProfile( String email, String password ){
        clickPersonalAreaButton();
        setEmailField(email);
        setPasswordField(password);
        clickEnterAuthorizationButton();
        personalAreaButton.shouldBe(visible);
        clickPersonalAreaButton();
        assertEquals(email, EmailFieldInProfile.getValue());
    }

    public void goToBurgerConstructor( String email, String password ){
        clickPersonalAreaButton();
        setEmailField(email);
        setPasswordField(password);
        clickEnterAuthorizationButton();
        personalAreaButton.shouldBe(visible);
        clickPersonalAreaButton();
        clickBurgerConstructorButton();
        createOrderButton.shouldBe(visible);
    }

    public void goToBurgerConstructorWithLogo( String email, String password ){
        clickPersonalAreaButton();
        setEmailField(email);
        setPasswordField(password);
        clickEnterAuthorizationButton();
        personalAreaButton.shouldBe(visible);
        clickPersonalAreaButton();
        clickLogoButton();
        createOrderButton.shouldBe(visible);
    }

    public void exitProfile( String email, String password ){
        clickPersonalAreaButton();
        setEmailField(email);
        setPasswordField(password);
        clickEnterAuthorizationButton();
        personalAreaButton.shouldBe(visible);
        clickPersonalAreaButton();
        clickExitButton();
        enterAuthorizationButton.shouldBe(visible);
    }


}
