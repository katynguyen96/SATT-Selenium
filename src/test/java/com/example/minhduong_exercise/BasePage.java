package com.example.minhduong_exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    @FindBy(xpath = "//div[@id='menu']")
    public WebElement navBar;

    @FindBy(xpath = "//div[@id='menu']//span[.='Login']/..")
    public WebElement loginTab;

    @FindBy(xpath = "//div[@class='account']/strong")
    public WebElement welcomeText;

    public void tabNavigate(String tabName) {
        navBar.findElement(By.xpath("//span[.="+ "'" +tabName + "'"+"]/..")).click();
    }

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
