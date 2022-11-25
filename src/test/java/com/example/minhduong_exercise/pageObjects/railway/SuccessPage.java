package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage {
    private final String rowTicketXpath = "//table[@class='MyTable WideTable']//td[count(//th[text()='%s']/preceding-sibling::th)+1]";

}
