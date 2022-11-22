package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class MyTicketPage extends BasePage {
    private final String cancelButton = "//input[@value='Cancel' and contains(@onclick,'%s')]";

    private WebElement getBtnCancel(String id) {
        return DriverManager.getDriver().findElement(By.xpath(String.format(cancelButton, id)));
    }

    public void deleteTicket(String id) {
        DriverManager.scrollToView(getBtnCancel(id));
        getBtnCancel(id).click();
    }

    public boolean isTicketDisplayed(String id) {
        try {
            getBtnCancel(id);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
