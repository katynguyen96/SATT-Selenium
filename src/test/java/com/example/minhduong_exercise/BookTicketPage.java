package com.example.minhduong_exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class BookTicketPage {
    @FindBy(xpath = "//input[@type='submit' and @value='Book ticket']")
    private WebElement bookTicketButton;

    @FindBy(xpath = "//select[@name='Date']")
    private WebElement departDate;

    @FindBy(xpath = "//select[@name='DepartStation']")
    private WebElement departStation;

    @FindBy(xpath = "//select[@name='ArriveStation']")
    private WebElement arriveStation;

    @FindBy(xpath = "//select[@name='SeatType']")
    private WebElement seatType;

    @FindBy(xpath = "//select[@name='TicketAmount']")
    private WebElement ticketAmount;

    public void departDateSelected(String value){
        departDate.findElement(By.xpath("/option[" + "'" + value + "'" +"]"));
    }

    public void departStationSelected(String value){
        departStation.findElement(By.xpath("/option[" + "'" + value + "'" +"]"));
    }

    public void arriveStationSelected(String value){
        arriveStation.findElement(By.xpath("/option[" + "'" + value + "'" +"]"));
    }
    public void seatTypeSelected(String value){
        seatType.findElement(By.xpath("/option[" + "'" + value + "'" +"]"));
    }
    public void ticketAmountSelected(String value){
        ticketAmount.findElement(By.xpath("/option[" + "'" + value + "'" +"]"));
    }
    public void bookTicket(){
        bookTicketButton.click();
    }

    public BookTicketPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
