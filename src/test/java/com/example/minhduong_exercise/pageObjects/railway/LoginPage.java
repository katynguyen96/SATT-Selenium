package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    //Locator
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@type='submit']");
    private final By stWelcomeText = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessageInvalidAccount = By.xpath("//div[@id='content']/p[contains(@class,'message error')]");
    private final By lblFormErrorMessage = By.xpath("//div[@id='content']//p[contains(@class,'message error')]");
    private final By mnuTabMenu = By.xpath("//div[@id='menu']");

    private final String tabXpath = "//span[.='%s']";

    //Element
}
