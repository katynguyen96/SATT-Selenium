package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {
    //Locator
    private final By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By btnChangePassword = By.xpath("//input[@type='submit' and @value='Change Password']");
    private final By pSuccessMessage = By.xpath("//form[@id='ChangePW']//p[@class='message success']");


    //Element
    protected WebElement getTxtCurrentPassword() {
        return DriverManager.getDriver().findElement(txtCurrentPassword);
    }

    protected WebElement getTxtNewPassword() {
        return DriverManager.getDriver().findElement(txtNewPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return DriverManager.getDriver().findElement(txtConfirmPassword);
    }

    protected WebElement getBtnChangePassword() {
        return DriverManager.getDriver().findElement(btnChangePassword);
    }

    protected WebElement getpSuccessMessage() {
        return DriverManager.getDriver().findElement(pSuccessMessage);
    }


    //Method
    public String getSuccessMessage() {
        return getpSuccessMessage().getText();
    }

    public void ChangePassword(String curPass, String newPass, String confrimPass) {
        getTxtCurrentPassword().sendKeys(curPass);
        getTxtNewPassword().sendKeys(newPass);
        getTxtConfirmPassword().sendKeys(confrimPass);
        getBtnChangePassword().click();
    }
}
