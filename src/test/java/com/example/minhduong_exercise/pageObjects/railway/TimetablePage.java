package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.constant.Station;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {
    protected WebElement getRow(Station departStation, Station arriveStation) {
        return DriverManager.getDriver().findElement(By.xpath("//table[@class='MyTable WideTable']//td[text()='" + departStation.getStation() + "']/following-sibling::td[text()='" + arriveStation.getStation() + "']/..//a[contains(@href,'BookTicket')]"));
    }

    public void clickLink(Station departStation, Station arriveStation){
        DriverManager.scrollToView(getRow(departStation, arriveStation));
        getRow(departStation,arriveStation).click();
    }
}
