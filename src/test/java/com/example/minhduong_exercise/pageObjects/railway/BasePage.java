package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

@Getter
public class BasePage {

    //Method
    public WebElement tabNavigate(Tab tabName) {
        return DriverManager.getDriver().findElement(By.xpath("//div[@id='menu']//span[.=" + "'" + tabName.getTabName() + "'" + "]/.."));
    }
}
