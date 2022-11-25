package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.dataObjects.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class MyTicketPage extends BasePage {

    private final By ddlDpStationSelect = By.xpath("//select[@name='FilterDpStation']");
    private final By btnApplyFilter = By.xpath("//div[@class='Filter']//input[@type='submit']");
    private final By txtDepartDate = By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']");
    private final By lblErrorMessage = By.xpath("//div[contains(@class,'error')]");

    private final String filterTableXpath = "//table[@class='MyTable']//td[position()=count(//tr[@class='TableSmallHeader']/th[.='Depart Station']/preceding-sibling::th)+1 and .='%s']";

    private WebElement getDdlDpStationSelect() {
        return DriverManager.getDriver().findElement(ddlDpStationSelect);
    }

    private WebElement getBtnApplyFilter() {
        return DriverManager.getDriver().findElement(btnApplyFilter);
    }

    private WebElement getTxtDepartDate() {
        return DriverManager.getDriver().findElement(txtDepartDate);
    }

    private WebElement getLblErrorMessage() {
        return DriverManager.getDriver().findElement(lblErrorMessage);
    }

    private Select getDpStation() {
        return new Select(getDdlDpStationSelect());
    }


    private WebElement getFilterRow(Station DpStation) {
        return DriverManager.getDriver().findElement(By.xpath(String.format(filterTableXpath, DpStation.getStation())));
    }

    public void filterDpStation(Station dpStation) {
        getDpStation().selectByVisibleText(dpStation.getStation());
        DriverManager.scrollToView(getBtnApplyFilter());
        getBtnApplyFilter().click();
    }

    public String getErrorMessage() {
        return getLblErrorMessage().getText();
    }

    public Boolean isTicketDisplay(Station dpStation) {
        try {
            return getFilterRow(dpStation).findElement(By.xpath("//ancestor::tr")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void filterDpDate(String value) {
        getTxtDepartDate().sendKeys(value);
        getBtnApplyFilter().click();
    }
}
