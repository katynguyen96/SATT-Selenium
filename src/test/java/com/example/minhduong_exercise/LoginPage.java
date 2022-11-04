package com.example.minhduong_exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passWord;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    public void loginAccount(){
        userName.sendKeys("abc@gmail.com");
        passWord.sendKeys("111111111");
        loginButton.click();
    }

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
