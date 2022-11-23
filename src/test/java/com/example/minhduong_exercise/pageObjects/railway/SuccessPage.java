package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage {
    private final String rowTicketXpath = "//table[@class='MyTable WideTable']//td[count(//th[text()='%s']/preceding-sibling::th)+1]";

    private WebElement getRow(String value) {
        return DriverManager.getDriver().findElement(By.xpath(String.format(rowTicketXpath, value)));
    }

    public String getRowValue(String value) {
        return getRow(value).getText();

    }

    public String getTicketID() {
        return DriverManager.getParamValue("id");
    }
}
