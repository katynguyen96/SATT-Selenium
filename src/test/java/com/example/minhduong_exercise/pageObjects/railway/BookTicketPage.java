package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.dataObjects.Station;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BookTicketPage extends BasePage {
    //Locator
    private final By btnBookTicket = By.xpath("//input[@type='submit' and @value='Book ticket']");
    private final By ddlDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By ddlArriveStation = By.xpath("//select[@name='ArriveStation']");


    private WebElement getBtnBookTicket() {
        return DriverManager.getDriver().findElement(btnBookTicket);
    }

    private WebElement getDdlDepartStation() {
        return DriverManager.getDriver().findElement(ddlDepartStation);
    }

    private WebElement getDdlArriveStation() {
        return DriverManager.getDriver().findElement(ddlArriveStation);
    }

    public Select getDdlDepartStationSelect() {
        return new Select(getDdlDepartStation());
    }

    public Select getDdlArriveStationSelect() {
        return new Select(getDdlArriveStation());
    }

    public void bookTicket(Station departStationValue, Station arriveStation) {
        getDdlDepartStationSelect().selectByVisibleText(departStationValue.getStation());
        getDdlArriveStationSelect().selectByVisibleText(arriveStation.getStation());
        DriverManager.scrollToView(getBtnBookTicket());
        getBtnBookTicket().click();
    }

    public void bookTicketForFilterDepartDate() {
        DriverManager.scrollToView(getBtnBookTicket());
        getBtnBookTicket().click();
    }
}
