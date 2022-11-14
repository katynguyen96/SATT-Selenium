package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    //Locator
    private final By loc_txtEmail = By.xpath("//input[@id='email']");
    private final By loc_txtPassword = By.xpath("//input[@id='password']");
    private final By loc_txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By loc_txtPID = By.xpath("//input[@id='pid']");
    private final By loc_btnRegister = By.xpath("//form[@id='RegisterForm']//input[@type='submit']");
    private final By loc_paRegisterSuccessMessage = By.xpath("//div[@id='content']/p");
    private final By loc_lblErrorMessageConfirmPassword = By.xpath("//label[@for='confirmPassword' and contains(@class,'validation-error')]");
    private final By loc_lblErrorMessagePassword = By.xpath("//label[@for='password' and contains(@class,'validation-error')]");
    private final By loc_paFormErrorMessage = By.xpath("//div[@id='content']//p[contains(@class,'message error')]");


    //Element
    protected WebElement getLoc_txtEmail() {
        return DriverManager.getDriver().findElement(loc_txtEmail);
    }

    protected WebElement getLoc_txtPassword() {
        return DriverManager.getDriver().findElement(loc_txtPassword);
    }


    protected WebElement getLoc_txtConfirmPassword() {
        return DriverManager.getDriver().findElement(loc_txtConfirmPassword);
    }


    protected WebElement getLoc_txtPID() {
        return DriverManager.getDriver().findElement(loc_txtPID);
    }


    protected WebElement getLoc_btnRegister() {
        return DriverManager.getDriver().findElement(loc_btnRegister);
    }


    protected WebElement getLoc_paRegisterSuccessMessage() {
        return DriverManager.getDriver().findElement(loc_paRegisterSuccessMessage);
    }

    protected WebElement getLoc_lblErrorMessageConfirmPassword() {
        return DriverManager.getDriver().findElement(loc_lblErrorMessageConfirmPassword);

    }

    protected WebElement getLoc_lblErrorMessagePassword() {
        return DriverManager.getDriver().findElement(loc_lblErrorMessagePassword);
    }

    protected WebElement getLoc_paFormErrorMessage() {
        return DriverManager.getDriver().findElement(loc_paFormErrorMessage);
    }


    //Method
    public String getRegisterSuccessMessage() {
        return getLoc_paRegisterSuccessMessage().getText();
    }


    public String getErrorMessageConfirmPassword() {
        return getLoc_lblErrorMessageConfirmPassword().getText();
    }


    public String getErrorMessagePassword() {
        return getLoc_lblErrorMessagePassword().getText();
    }


    public String getFormErrorMessage() {
        return getLoc_paFormErrorMessage().getText();
    }

    public void registerAccount(String email, String password, String confirmPassword, String PID) {
        getLoc_txtEmail().sendKeys(email);
        getLoc_txtPassword().sendKeys(password);
        getLoc_txtConfirmPassword().sendKeys(confirmPassword);
        getLoc_txtPID().sendKeys(PID);
        DriverManager.scrollToView(getLoc_btnRegister());
        getLoc_btnRegister().click();
    }
}
