package ru.yandex.praktikum.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.Assert.assertEquals;

public class BurgerConstructorPage {

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
}
