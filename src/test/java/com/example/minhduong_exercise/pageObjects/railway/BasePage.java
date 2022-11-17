package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class BasePage {

    //Method
    protected WebElement getTab(Tab tabName) {
        return DriverManager.getDriver().findElement(By.xpath("//div[@id='menu']//span[.=" + "'" + tabName.getTabName() + "'" + "]/.."));
    }

    public void tabNavigate(Tab tabName){
        getTab(tabName).click();
    }
}
