package com.example.minhduong_exercise.testcases.myTicket;

import com.example.minhduong_exercise.dataObjects.SeatType;
import com.example.minhduong_exercise.dataObjects.Station;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.MyTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.SuccessPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16_MyTicket_CancelTicket extends BaseTestSetUp {

    @Test(description = "TC16_User can cancel a ticket")
    public void TC16_CancelTicket() {
        Log.info("TC16_User can cancel a ticket");
        Log.info("Navigate to QA Railway Website");
        Log.info("Register new account");
        registerRandomAccount();
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info("Login with valid account");
        loginPage.loginAccount(getEmail(), getPassword());

        MyTicketPage myTicketPage = new MyTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        SuccessPage successPage = new SuccessPage();
        bookTicketPage.tabNavigate(Tab.BOOK_TICKET);
        String departDateValue = Utilities.generateRandomNumberDepartDate();
        Log.info("Book a ticket");
        bookTicketPage.bookTicket(departDateValue, Station.SAI_GON, Station.NHA_TRANG, SeatType.SBC, "1");
        String ticketID = successPage.getTicketID();

        Log.info("Click on \"My ticket\" tab");
        myTicketPage.tabNavigate(Tab.MY_TICKET);
        Log.info("Click on \"Cancel\" button of ticket which user want to cancel.");
        myTicketPage.deleteTicket(ticketID);
        Log.info(" Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        DriverManager.alertAccept();
        Assert.assertFalse(myTicketPage.isTicketDisplayed(ticketID), "Ticket ID: "+ticketID+" is display on UI");
    }
}
