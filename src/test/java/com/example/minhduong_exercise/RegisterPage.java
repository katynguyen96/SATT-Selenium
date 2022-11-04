package com.example.minhduong_exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RegisterPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@id='pid']")
    private WebElement PIDField;

    @FindBy(xpath = "//div[@id='content']/p")
    private WebElement registerMessage;

    @FindBy(xpath = "//p[@class='form-actions']/input[@type='submit' and @value='Register']")
    private WebElement registerButton;

    public void registerAccount(String email, String password, String confirmPassword, String PID){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        PIDField.sendKeys(PID);
        registerButton.click();
    }

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
