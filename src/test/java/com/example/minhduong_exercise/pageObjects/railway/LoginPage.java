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
    private final By pErrorMessageInvalidAccount = By.xpath("//div[@id='content']/p[contains(@class,'message error')]");
    private final By pFormErrorMessage = By.xpath("//div[@id='content']//p[contains(@class,'message error')]");
    private final By mnuTabMenu = By.xpath("//div[@id='menu']");


    //Element
    protected WebElement getTxtUsername() {
        return DriverManager.getDriver().findElement(txtUsername);
    }

    protected WebElement getTxtPassword() {
        return DriverManager.getDriver().findElement(txtPassword);
    }

    protected WebElement getBtnLogin() {
        return DriverManager.getDriver().findElement(btnLogin);
    }

    protected WebElement getStWelcomeText() {
        return DriverManager.getDriver().findElement(stWelcomeText);
    }

    protected WebElement getpFormErrorMessage() {
        return DriverManager.getDriver().findElement(pFormErrorMessage);
    }

    protected WebElement getMnuTabMenu() {
        return DriverManager.getDriver().findElement(mnuTabMenu);
    }

    protected WebElement getpErrorMessageInvalidAccount() {
        return DriverManager.getDriver().findElement(pErrorMessageInvalidAccount);
    }


    //Method
    public String getErrorMessageInvalidAccount() {
        return getpErrorMessageInvalidAccount().getText();
    }

    public String getWelcomeText() {
        return getStWelcomeText().getText();
    }

    public String getFormErrorMessage() {
        return getpFormErrorMessage().getText();
    }


    protected WebElement getTab(String tabName) {
        return getMnuTabMenu().findElement(By.xpath("//span[.=" + "'" + tabName + "'" + "]"));
    }

    public Boolean isTabDisplayed(String tabName){
        return getTab(tabName).isDisplayed();
    }

    public void loginAccount(String userName, String passWord) {
        getTxtUsername().sendKeys(userName);
        getTxtPassword().sendKeys(passWord);
        DriverManager.scrollToView(getBtnLogin());
        getBtnLogin().click();
    }
}
