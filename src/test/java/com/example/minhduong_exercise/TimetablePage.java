package com.example.minhduong_exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class TimetablePage {

    @FindBy(xpath = "//table[@class='MyTable WideTable']//tbody")
    private WebElement checkPriceLinkTag;

    @FindBy(xpath = "//table[@class='MyTable WideTable']//tbody")
    private WebElement bookTicketLinkTag;
}
