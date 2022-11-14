package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //Locator
    private final By loc_txtUsername = By.xpath("//input[@id='username']");
    private final By loc_txtPassword = By.xpath("//input[@id='password']");
    private final By loc_btnLogin = By.xpath("//input[@type='submit']");
    private final By loc_stWelcomeText = By.xpath("//div[@class='account']/strong");
    private final By loc_paErrorMessageInvalidAccount = By.xpath("//div[@id='content']/p[contains(@class,'message error')]");
    private final By loc_paFormErrorMessage = By.xpath("//div[@id='content']//p[contains(@class,'message error')]");
    private final By loc_mnuTabMenu = By.xpath("//div[@id='menu']");


    //Element
    protected WebElement getLoc_txtUsername() {
        return DriverManager.getDriver().findElement(loc_txtUsername);
    }

    protected WebElement getLoc_txtPassword() {
        return DriverManager.getDriver().findElement(loc_txtPassword);
    }

    protected WebElement getLoc_btnLogin() {
        return DriverManager.getDriver().findElement(loc_btnLogin);
    }

    protected WebElement getLoc_stWelcomeText() {
        return DriverManager.getDriver().findElement(loc_stWelcomeText);
    }

    protected WebElement getLoc_paFormErrorMessage() {
        return DriverManager.getDriver().findElement(loc_paFormErrorMessage);
    }

    protected WebElement getLoc_mnuTabMenu() {
        return DriverManager.getDriver().findElement(loc_mnuTabMenu);
    }

    protected WebElement getLoc_paErrorMessageInvalidAccount() {
        return DriverManager.getDriver().findElement(loc_paErrorMessageInvalidAccount);
    }


    //Method
    public String getErrorMessageInvalidAccount() {
        return getLoc_paErrorMessageInvalidAccount().getText();
    }

    public String getWelcomeText() {
        return getLoc_stWelcomeText().getText();
    }


    public String getFormErrorMessage() {
        return getLoc_paFormErrorMessage().getText();
    }


    public WebElement getTab(String tabName) {
        return getLoc_mnuTabMenu().findElement(By.xpath("//span[.=" + "'" + tabName + "'" + "]"));
    }

    public void loginAccount(String userName, String passWord) {
        getLoc_txtUsername().sendKeys(userName);
        Log.info("Step #3: Input username");
        getLoc_txtPassword().sendKeys(passWord);
        Log.info("Step #4: Input password");
        DriverManager.scrollToView(getLoc_btnLogin());
        getLoc_btnLogin().click();
        Log.info("Step #5: Click Login button");
    }
}
