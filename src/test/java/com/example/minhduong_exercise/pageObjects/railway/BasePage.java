package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

@Getter
public class BasePage {
    //Locator
    private final By loc_mnuNavBar = By.xpath("//div[@id='menu']");

    //Element
    protected WebElement getLoc_mnuNavBar() {
        return DriverManager.getDriver().findElement(loc_mnuNavBar);
    }


    //Method
    public void tabNavigate(String tabName) {
        getLoc_mnuNavBar().findElement(By.xpath("//span[.=" + "'" + tabName + "'" + "]/..")).click();
    }
}
