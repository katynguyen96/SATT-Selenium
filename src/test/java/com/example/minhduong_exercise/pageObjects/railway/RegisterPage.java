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
    private final By lblRegisterSuccessMessage = By.xpath("//div[@id='content']/p");
    private final By lblErrorMessagePIDPassword = By.xpath("//label[@for='pid' and contains(@class,'validation-error')]");
    private final By lblErrorMessagePassword = By.xpath("//label[@for='password' and contains(@class,'validation-error')]");
    private final By lblFormErrorMessage = By.xpath("//div[@id='content']//p[contains(@class,'message error')]");


    //Element
    private WebElement getTxtEmail() {
        return DriverManager.getDriver().findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return DriverManager.getDriver().findElement(txtPassword);
    }


    private WebElement getTxtConfirmPassword() {
        return DriverManager.getDriver().findElement(txtConfirmPassword);
    }


    private WebElement getTxtPID() {
        return DriverManager.getDriver().findElement(txtPID);
    }


    private WebElement getBtnRegister() {
        return DriverManager.getDriver().findElement(btnRegister);
    }


    private WebElement getLblRegisterSuccessMessage() {
        return DriverManager.getDriver().findElement(lblRegisterSuccessMessage);
    }

    private WebElement getLblErrorMessagePIDPassword() {
        return DriverManager.getDriver().findElement(lblErrorMessagePIDPassword);

    }

    private WebElement getLblErrorMessagePassword() {
        return DriverManager.getDriver().findElement(lblErrorMessagePassword);
    }

    private WebElement getLblFormErrorMessage() {
        return DriverManager.getDriver().findElement(lblFormErrorMessage);
    }


    //Method
    public String getRegisterSuccessMessage() {
        return getLblRegisterSuccessMessage().getText();
    }


    public String getErrorMessagePIDPassword() {
        return getLblErrorMessagePIDPassword().getText();
    }


    public String getErrorMessagePassword() {
        return getLblErrorMessagePassword().getText();
    }


    public String getFormErrorMessage() {
        return getLblFormErrorMessage().getText();
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
