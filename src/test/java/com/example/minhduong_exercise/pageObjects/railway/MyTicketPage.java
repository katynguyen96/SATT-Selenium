package com.example.minhduong_exercise.pageObjects.railway;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends BasePage {
    private final By btnCancel = By.xpath("//input[@value='Cancel']");
    private final By tblTicket = By.xpath("//div[@id='content']//div[@class='DivTable']//table");
    private String deletedTicketID;

    protected WebElement getBtnCancel() {
        return DriverManager.getDriver().findElement(btnCancel);
    }


    public String getDeletedTicketID() {
        return deletedTicketID;
    }

    public Boolean isTableDisplayed() {
        return DriverManager.getDriver().findElements(tblTicket).isEmpty();
    }

    public void deleteTicket() {
        DriverManager.scrollToView(getBtnCancel());
        deletedTicketID = getBtnCancel().getAttribute("onclick");
        deletedTicketID = deletedTicketID.substring(deletedTicketID.indexOf("(") + 1, deletedTicketID.indexOf(")"));
        getBtnCancel().click();
    }

    public String getNextTicketID() {
        List<WebElement> ticketRemain = DriverManager.getDriver().findElements(btnCancel);
        if (ticketRemain.size() != 0) {
            DriverManager.scrollToView(getBtnCancel());
            String nextTicketID = getBtnCancel().getAttribute("onclick");
            nextTicketID = nextTicketID.substring(nextTicketID.indexOf("(") + 1, nextTicketID.indexOf(")"));
            return nextTicketID;
        } else return null;
    }
}
