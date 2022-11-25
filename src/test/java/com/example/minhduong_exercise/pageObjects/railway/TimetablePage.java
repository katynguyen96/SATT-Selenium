package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.dataObjects.Station;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {
    private final String timeTableRowXpath = "//table[@class='MyTable WideTable']//td[text()='%s']/following-sibling::td[text()='%s']/..//a[contains(@href,'BookTicket')]";
}
