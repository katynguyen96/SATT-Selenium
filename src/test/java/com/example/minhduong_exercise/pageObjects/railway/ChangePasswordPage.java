package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {
    //Locator
    private final By loc_txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By loc_txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By loc_txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By loc_btnChangePassword = By.xpath("//input[@type='submit' and @value='Change Password']");
    private final By loc_paSuccessMessage = By.xpath("//form[@id='ChangePW']//p[@class='message success']");


    //Element
    protected WebElement getLoc_txtCurrentPassword() {
        return DriverManager.getDriver().findElement(loc_txtCurrentPassword);
    }

    protected WebElement getLoc_txtNewPassword() {
        return DriverManager.getDriver().findElement(loc_txtNewPassword);
    }

    protected WebElement getLoc_txtConfirmPassword() {
        return DriverManager.getDriver().findElement(loc_txtConfirmPassword);
    }

    protected WebElement getLoc_btnChangePassword() {
        return DriverManager.getDriver().findElement(loc_btnChangePassword);
    }

    protected WebElement getLoc_paSuccessMessage() {
        return DriverManager.getDriver().findElement(loc_paSuccessMessage);
    }


    //Method
    public String getSuccessMessage() {
        return getLoc_paSuccessMessage().getText();
    }

    public void ChangePassword(String curPass, String newPass, String confrimPass) {
        getLoc_txtCurrentPassword().sendKeys(curPass);
        getLoc_txtNewPassword().sendKeys(newPass);
        getLoc_txtConfirmPassword().sendKeys(confrimPass);
        getLoc_btnChangePassword().click();
    }
}
