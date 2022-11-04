package com.example.minhduong_exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ContactPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='contact']//a[contains(text(),'@logigear.com')]")
    private WebElement emailLink;

    public void openEmailBox(){
        emailLink.click();
    }
}
