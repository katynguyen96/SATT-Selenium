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
    private final By lblSuccessMessage = By.xpath("//form[@id='ChangePW']//p[@class='message success']");


    //Element
    private WebElement getTxtCurrentPassword() {
        return DriverManager.getDriver().findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword() {
        return DriverManager.getDriver().findElement(txtNewPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverManager.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword() {
        return DriverManager.getDriver().findElement(btnChangePassword);
    }

    private WebElement getLblSuccessMessage() {
        return DriverManager.getDriver().findElement(lblSuccessMessage);
    }


    //Method
    public String getSuccessMessage() {
        return getLblSuccessMessage().getText();
    }

    public void ChangePassword(String curPass, String newPass, String confirmPass) {
        getTxtCurrentPassword().sendKeys(curPass);
        getTxtNewPassword().sendKeys(newPass);
        getTxtConfirmPassword().sendKeys(confirmPass);
        getBtnChangePassword().click();
    }
}
