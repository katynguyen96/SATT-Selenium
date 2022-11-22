package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.constant.Station;
import com.example.minhduong_exercise.common.constant.SeatType;
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


    //Element
    protected WebElement getBtnBookTicket() {
        return DriverManager.getDriver().findElement(btnBookTicket);
    }


    protected WebElement getDdlDepartDate() {
        return DriverManager.getDriver().findElement(ddlDepartDate);
    }


    protected WebElement getDdlDepartStation() {
        return DriverManager.getDriver().findElement(ddlDepartStation);
    }


    protected WebElement getDdlArriveStation() {
        return DriverManager.getDriver().findElement(ddlArriveStation);
    }


    protected WebElement getDdlSeatType() {
        return DriverManager.getDriver().findElement(ddlSeatType);
    }


    protected WebElement getDdlTicketAmount() {
        return DriverManager.getDriver().findElement(ddlTicketAmount);
    }


    protected WebElement getLblSuccessTitle() {
        return DriverManager.getDriver().findElement(lblSuccessTitle);
    }

    protected WebElement departDate(String value) {
        return getDdlDepartDate().findElement(By.xpath("//option[@value='" + value + "']"));
    }

    protected WebElement getSelectedArriveStation() {
        return getDdlArriveStationSelect().getFirstSelectedOption();
    }

    protected WebElement getSelectedDepartStation() {
        return getDdlDepartStationSelect().getFirstSelectedOption();
    }

    //Method
    public String getSuccessTitleValue() {
        return getLblSuccessTitle().getText();
    }

    public Select getDdlDepartDateSelect() {
        return new Select(getDdlDepartDate());
    }

    public Select getDdlDepartStationSelect() {
        return new Select(getDdlDepartStation());
    }

    public Select getDdlArriveStationSelect() {
        return new Select(getDdlArriveStation());
    }

    public Select getDdlSeatTypeSelect() {
        return new Select(getDdlSeatType());
    }

    public Select getDdlTicketAmountSelect() {
        return new Select(getDdlTicketAmount());
    }


    public void bookTicket(String departDateValue, Station departStationValue, Station arriveStationValue, SeatType seatValue, String amountValue) {
        getDdlDepartDateSelect().selectByValue(departDateValue);
        getDdlDepartStationSelect().selectByVisibleText(departStationValue.getStation());
        getDdlArriveStationSelect().selectByVisibleText(arriveStationValue.getStation());
        getDdlSeatTypeSelect().selectByVisibleText(seatValue.getSeatType());
        getDdlTicketAmountSelect().selectByVisibleText(amountValue);
        DriverManager.scrollToView(getBtnBookTicket());
        getBtnBookTicket().click();
    }

    public String getSelectedDepartStationValue() {
        return getSelectedDepartStation().getText();
    }


    public String getSelectedArriveStationValue() {
        return getSelectedArriveStation().getText();
    }


    public String getDepartDateValue(String value) {
        return departDate(value).getText();
    }
}
