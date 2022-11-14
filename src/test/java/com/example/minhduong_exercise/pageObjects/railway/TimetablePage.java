package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {
    public WebElement getRow(String departStation, String arriveStation) {
        return DriverManager.getDriver().findElement(By.xpath("//table[@class='MyTable WideTable']//td[text()='" + departStation + "']/following-sibling::td[text()='" + arriveStation + "']/..//a[contains(@href,'BookTicket')]"));
    }
}
