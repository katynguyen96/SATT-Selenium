package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {
    private final By btnCancel = By.xpath("//input[@value='Cancel']");
    private final By tblTicket = By.className("DivTable");
    private String deletedTicketID;

    protected WebElement getBtnCancel() {
        return DriverManager.getDriver().findElement(btnCancel);
    }


    public String getDeletedTicketID() {
        return deletedTicketID;
    }

    public Boolean isTableDisplayed() {
        try {
            DriverManager.getDriver().findElement(tblTicket);
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }

    public void deleteTicket() {
        DriverManager.scrollToView(getBtnCancel());
        deletedTicketID = getBtnCancel().getAttribute("onclick");
        deletedTicketID = deletedTicketID.substring(deletedTicketID.indexOf("(") + 1, deletedTicketID.indexOf(")"));
        getBtnCancel().click();
    }

    public String getNextTicketID() {
        try{
            DriverManager.scrollToView(getBtnCancel());
            String nextTicketID = getBtnCancel().getAttribute("onclick");
            nextTicketID = nextTicketID.substring(nextTicketID.indexOf("(") + 1, nextTicketID.indexOf(")"));
            return nextTicketID;
        } catch(org.openqa.selenium.NoSuchElementException e){
            return null;
        }
    }
}
