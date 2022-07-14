package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.Assert.assertEquals;

public class RegistrationAndLoginPage {
    @FindBy(how = How.LINK_TEXT,using = "Личный Кабинет")
    private SelenideElement personalAreaButton;

    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;
    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")
    private SelenideElement emailField;

    @FindBy(how = How.CSS,using = "[name=name]")
    private SelenideElement secondEmailField;

    @FindBy(how = How.CSS,using = "[name=Пароль]")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement confirmRegistrationButton;

    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement enterAuthorizationButton;

    @FindBy(how = How.XPATH,using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement failedMessageText;

    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement loginButtonInRegistrationPageAndRestorePasswordPage;

    @FindBy(how = How.LINK_TEXT,using = "Восстановить пароль")
    private SelenideElement restorePasswordButton;

    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement saucesButton;
    @FindBy(how = How.XPATH,using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;
    @FindBy(how = How.XPATH,using = ".//span[text()='Начинки']")
    private SelenideElement toppingsButton;

    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private SelenideElement currentTab;

    public void clickSaucesButton() {
        saucesButton.click();
    }

    public void clickBunsButton() {
        bunsButton.click();
    }

    public void clickToppingsButton() {
        toppingsButton.click();
    }

    public void clickToTopping(String expectedTab ){
        clickToppingsButton();
        assertEquals(expectedTab, currentTab.getText());
    }

    public void clickToBun(String expectedTab ){
        clickToppingsButton();
        clickBunsButton();
        assertEquals(expectedTab, currentTab.getText());
    }

    public void clickToSauces(String expectedTab ){
        clickSaucesButton();
        assertEquals(expectedTab, currentTab.getText());
    }

    public void clickPersonalAreaButton() {
        personalAreaButton.click();
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public void setNameField(String name) {
        nameField.setValue(name);
    }

    public void setEmailField(String name) {
        emailField.setValue(name);
    }

    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }
    public void clickConfirmRegistrationButton() {
        confirmRegistrationButton.click();
    }

    public void clickEnterAuthorizationButton() {
        enterAuthorizationButton.click();
    }

    public void setSecondEmailField(String email) {

        secondEmailField.shouldBe(visible).setValue(email);
    }

    public void clickEmailField() {
        emailField.click();
    }
    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLoginInRegistrationPageAndRestorePasswordPage() {
        loginButtonInRegistrationPageAndRestorePasswordPage.click();
    }

    public void clickRestorePasswordButtonInRegistrationPage() {
        restorePasswordButton.click();
    }


    public void createUser(String name, String email, String password ){
        clickPersonalAreaButton();
        clickRegistrationButton();

        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickConfirmRegistrationButton();
    }
    public void failedCreateUser(String name, String email, String password ){
        clickPersonalAreaButton();
        clickRegistrationButton();

        setNameField(name);
        setEmailField(email);
        setPasswordField(password);

        clickEmailField();
        failedMessageText.shouldBe(visible);
    }

    public void loginWithLoginButton( String email, String password ){
        clickLoginButton();
        setSecondEmailField(email);
        setPasswordField(password);
        clickEnterAuthorizationButton();
        createOrderButton.shouldBe(visible);
    }

    public void loginWithPersonalAreaButton( String email, String password ){
        clickPersonalAreaButton();
        setSecondEmailField(email);
        setPasswordField(password);
        clickEnterAuthorizationButton();
        createOrderButton.shouldBe(visible);
    }

    public void loginWithLoginButtonInRegistrationPage( String email, String password ){
        clickLoginButton();
        clickRegistrationButton();
        clickLoginInRegistrationPageAndRestorePasswordPage();
        setSecondEmailField(email);
        setPasswordField(password);
        clickEnterAuthorizationButton();
        createOrderButton.shouldBe(visible);
    }

    public void loginWithRestorePasswordButtonInRegistrationPage( String email, String password ){
        clickLoginButton();
        clickRestorePasswordButtonInRegistrationPage();
        clickLoginInRegistrationPageAndRestorePasswordPage();

        setSecondEmailField(email);
        setPasswordField(password);
        clickEnterAuthorizationButton();
        createOrderButton.shouldBe(visible);


    }

}
