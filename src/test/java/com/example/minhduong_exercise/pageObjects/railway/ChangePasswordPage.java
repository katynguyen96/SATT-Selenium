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
}
