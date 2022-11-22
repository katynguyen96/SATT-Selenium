package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class BasePage {
    //Method
    String tabXpath = "//div[@id='menu']//span[.= '%s' ]/..";

    protected WebElement getTab(Tab tabName) {
        return DriverManager.getDriver().findElement(By.xpath(String.format(tabXpath, tabName.getTabName())));
    }

    public void tabNavigate(Tab tabName) {
        getTab(tabName).click();
    }
}
