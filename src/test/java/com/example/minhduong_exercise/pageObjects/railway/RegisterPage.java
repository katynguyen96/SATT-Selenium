package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    //Locator
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPID = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//form[@id='RegisterForm']//input[@type='submit']");
    private final By pRegisterSuccessMessage = By.xpath("//div[@id='content']/p");
    private final By lblErrorMessageConfirmPassword = By.xpath("//label[@for='confirmPassword' and contains(@class,'validation-error')]");
    private final By lblErrorMessagePassword = By.xpath("//label[@for='password' and contains(@class,'validation-error')]");
    private final By pFormErrorMessage = By.xpath("//div[@id='content']//p[contains(@class,'message error')]");


    //Element
    protected WebElement getTxtEmail() {
        return DriverManager.getDriver().findElement(txtEmail);
    }

    protected WebElement getTxtPassword() {
        return DriverManager.getDriver().findElement(txtPassword);
    }


    protected WebElement getTxtConfirmPassword() {
        return DriverManager.getDriver().findElement(txtConfirmPassword);
    }


    protected WebElement getTxtPID() {
        return DriverManager.getDriver().findElement(txtPID);
    }


    protected WebElement getBtnRegister() {
        return DriverManager.getDriver().findElement(btnRegister);
    }


    protected WebElement getpRegisterSuccessMessage() {
        return DriverManager.getDriver().findElement(pRegisterSuccessMessage);
    }

    protected WebElement getLblErrorMessageConfirmPassword() {
        return DriverManager.getDriver().findElement(lblErrorMessageConfirmPassword);

    }

    protected WebElement getLblErrorMessagePassword() {
        return DriverManager.getDriver().findElement(lblErrorMessagePassword);
    }

    protected WebElement getpFormErrorMessage() {
        return DriverManager.getDriver().findElement(pFormErrorMessage);
    }


    //Method
    public String getRegisterSuccessMessage() {
        return getpRegisterSuccessMessage().getText();
    }


    public String getErrorMessageConfirmPassword() {
        return getLblErrorMessageConfirmPassword().getText();
    }


    public String getErrorMessagePassword() {
        return getLblErrorMessagePassword().getText();
    }


    public String getFormErrorMessage() {
        return getpFormErrorMessage().getText();
    }

    public void registerAccount(String email, String password, String confirmPassword, String PID) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPID().sendKeys(PID);
        DriverManager.scrollToView(getBtnRegister());
        getBtnRegister().click();
    }
}
