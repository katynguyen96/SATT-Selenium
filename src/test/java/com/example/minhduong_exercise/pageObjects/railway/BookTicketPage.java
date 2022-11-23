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


    //Element
    private WebElement getBtnBookTicket() {
        return DriverManager.getDriver().findElement(btnBookTicket);
    }


    private WebElement getDdlDepartDate() {
        return DriverManager.getDriver().findElement(ddlDepartDate);
    }


    private WebElement getDdlDepartStation() {
        return DriverManager.getDriver().findElement(ddlDepartStation);
    }


    private WebElement getDdlArriveStation() {
        return DriverManager.getDriver().findElement(ddlArriveStation);
    }


    private WebElement getDdlSeatType() {
        return DriverManager.getDriver().findElement(ddlSeatType);
    }


    private WebElement getDdlTicketAmount() {
        return DriverManager.getDriver().findElement(ddlTicketAmount);
    }


    private WebElement getLblSuccessTitle() {
        return DriverManager.getDriver().findElement(lblSuccessTitle);
    }

    private WebElement departDate(String value) {
        return getDdlDepartDate().findElement(By.xpath(String.format(departDateXpath, value)));
    }

    private WebElement getSelectedArriveStation() {
        return getDdlArriveStationSelect().getFirstSelectedOption();
    }

    private WebElement getSelectedDepartStation() {
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
