package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.constant.Station;
import com.example.minhduong_exercise.common.constant.SeatType;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BookTicketPage extends BasePage {
    //Locator
    private final By loc_btnBookTicket = By.xpath("//input[@type='submit' and @value='Book ticket']");
    private final By loc_ddlDepartDate = By.xpath("//select[@name='Date']");
    private final By loc_ddlDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By loc_ddlArriveStation = By.xpath("//select[@name='ArriveStation']");
    private final By loc_ddlSeatType = By.xpath("//select[@name='SeatType']");
    private final By loc_ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By loc_successTitle = By.xpath("//h1");


    //Element
    protected WebElement getLoc_btnBookTicket() {
        return DriverManager.getDriver().findElement(loc_btnBookTicket);
    }


    protected WebElement getLoc_ddlDepartDate() {
        return DriverManager.getDriver().findElement(loc_ddlDepartDate);
    }


    protected WebElement getLoc_ddlDepartStation() {
        return DriverManager.getDriver().findElement(loc_ddlDepartStation);
    }


    protected WebElement getLoc_ddlArriveStation() {
        return DriverManager.getDriver().findElement(loc_ddlArriveStation);
    }


    protected WebElement getLoc_ddlSeatType() {
        return DriverManager.getDriver().findElement(loc_ddlSeatType);
    }


    protected WebElement getloc_ddlTicketAmount() {
        return DriverManager.getDriver().findElement(loc_ddlTicketAmount);
    }


    protected WebElement getLoc_successTitle() {
        return DriverManager.getDriver().findElement(loc_successTitle);
    }


    //Method
    public String getSuccessTitle() {
        return getLoc_successTitle().getText();
    }

    public Select getLoc_ddlDepartDateSelect() {
        return new Select(getLoc_ddlDepartDate());
    }

    public Select getLoc_ddlDepartStationSelect() {
        return new Select(getLoc_ddlDepartStation());
    }

    public Select getLoc_ddlArriveStationSelect() {
        return new Select(getLoc_ddlArriveStation());
    }

    public Select getLoc_ddlSeatTypeSelect() {
        return new Select(getLoc_ddlSeatType());
    }

    public Select getLoc_ddlTicketAmountSelect() {
        return new Select(getloc_ddlTicketAmount());
    }


    public void bookTicket(String departDateValue, Station departStationValue, Station arriveStationValue, SeatType seatValue, String amountValue) {
        getLoc_ddlDepartDateSelect().selectByValue(departDateValue);
        getLoc_ddlDepartStationSelect().selectByVisibleText(departStationValue.getTabName());
        getLoc_ddlArriveStationSelect().selectByVisibleText(arriveStationValue.getTabName());
        getLoc_ddlSeatTypeSelect().selectByVisibleText(seatValue.getTabName());
        getLoc_ddlTicketAmountSelect().selectByVisibleText(amountValue);
        DriverManager.scrollToView(getLoc_btnBookTicket());
        getLoc_btnBookTicket().click();
    }

    public WebElement getSelectedDepartSationValue() {
        return getLoc_ddlDepartStationSelect().getFirstSelectedOption();
    }

    public WebElement getSelectedArriveStationValue() {
        return getLoc_ddlArriveStationSelect().getFirstSelectedOption();
    }

    public String departDate(String value) {
        DriverManager.scrollToView(getLoc_ddlDepartDate());
        getLoc_ddlDepartDate().click();
        String date = getLoc_ddlDepartDate().findElement(By.xpath("//option[@value='" + value + "']")).getText();
        return date;
    }
}
