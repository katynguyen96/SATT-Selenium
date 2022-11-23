package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    //Locator
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@type='submit']");
    private final By stWelcomeText = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessageInvalidAccount = By.xpath("//div[@id='content']/p[contains(@class,'message error')]");
    private final By lblFormErrorMessage = By.xpath("//div[@id='content']//p[contains(@class,'message error')]");
    private final By mnuTabMenu = By.xpath("//div[@id='menu']");

    private final String tabXpath = "//span[.='%s']";

    //Element
    private WebElement getTxtUsername() {
        return DriverManager.getDriver().findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return DriverManager.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverManager.getDriver().findElement(btnLogin);
    }

    private WebElement getStWelcomeText() {
        return DriverManager.getDriver().findElement(stWelcomeText);
    }

    private WebElement getLblFormErrorMessage() {
        return DriverManager.getDriver().findElement(lblFormErrorMessage);
    }

    private WebElement getMnuTabMenu() {
        return DriverManager.getDriver().findElement(mnuTabMenu);
    }

    private WebElement getLblErrorMessageInvalidAccount() {
        return DriverManager.getDriver().findElement(lblErrorMessageInvalidAccount);
    }


    //Method
    public String getErrorMessageInvalidAccount() {
        return getLblErrorMessageInvalidAccount().getText();
    }

    public String getWelcomeText() {
        return getStWelcomeText().getText();
    }

    public String getFormErrorMessage() {
        return getLblFormErrorMessage().getText();
    }


    private WebElement getTab(String tabName) {
        return getMnuTabMenu().findElement(By.xpath(String.format(tabXpath, tabName)));
    }

    public Boolean isTabDisplayed(String tabName) {
        return getTab(tabName).isDisplayed();
    }

    public void loginAccount(String userName, String passWord) {
        getTxtUsername().sendKeys(userName);
        getTxtPassword().sendKeys(passWord);
        DriverManager.scrollToView(getBtnLogin());
        getBtnLogin().click();
    }
}
