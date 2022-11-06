package com.example.minhduong_exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class TicketPricePage {
    @FindBy(xpath = "//table[@class='NoBorder']//td/a")
    private WebElement checkPriceButton;

    public TicketPricePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
