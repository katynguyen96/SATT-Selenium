package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.dataObjects.Station;
import com.example.minhduong_exercise.dataObjects.SeatType;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BookTicketPage extends BasePage {
    //Locator
    private final By btnBookTicket = By.xpath("//input[@type='submit' and @value='Book ticket']");
    private final By ddlDepartDate = By.xpath("//select[@name='Date']");
    private final By ddlDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By ddlArriveStation = By.xpath("//select[@name='ArriveStation']");
    private final By ddlSeatType = By.xpath("//select[@name='SeatType']");
    private final By ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By lblSuccessTitle = By.xpath("//h1");
    private final String departDateXpath = "//option[@value='%s']";

}
