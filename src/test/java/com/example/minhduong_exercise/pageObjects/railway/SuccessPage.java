package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage {
    protected WebElement getRow(String value) {
        return DriverManager.getDriver().findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[text()=" + "'" + value + "'" + "]/preceding-sibling::th)+1]"));
    }

    public String getRowValue(String value) {
        return getRow(value).getText();

    }

    public String getRowValue(String value) {
        return getRow(value).getText();
    }

}
