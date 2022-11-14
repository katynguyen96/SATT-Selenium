package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;

public class SuccessPage extends BasePage {
    public String getRow(String value) {
        String select = DriverManager.getDriver().findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[text()=" + "'" + value + "'" + "]/preceding-sibling::th)+1]")).getText();
        System.out.println(select);
        return select;
    }
}
