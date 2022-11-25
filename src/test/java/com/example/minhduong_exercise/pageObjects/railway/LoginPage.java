package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    //Locator
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@type='submit']");

    //Element
    private WebElement getTxtUsername() {
        return DriverManager.getDriver().findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return DriverManager.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverManager.getDriver().findElement(btnLogin);
    }

    //Method
    public void loginAccount(String userName, String passWord) {
        getTxtUsername().sendKeys(userName);
        getTxtPassword().sendKeys(passWord);
        DriverManager.scrollToView(getBtnLogin());
        getBtnLogin().click();
    }
}
