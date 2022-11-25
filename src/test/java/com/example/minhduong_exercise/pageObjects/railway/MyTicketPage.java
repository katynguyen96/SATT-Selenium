package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.utilities.reader.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class MyTicketPage extends BasePage {
    private final String cancelButton = "//input[@value='Cancel' and contains(@onclick,'%s')]";

}
