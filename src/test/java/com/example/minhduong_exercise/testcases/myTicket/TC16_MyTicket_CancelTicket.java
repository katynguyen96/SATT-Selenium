package com.example.minhduong_exercise.testcases.myTicket;

import com.example.minhduong_exercise.dataObjects.SeatType;
import com.example.minhduong_exercise.dataObjects.Station;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.common.utilities.reader.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.MyTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.SuccessPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16_MyTicket_CancelTicket extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test(description = "TC16_User can cancel a ticket")
    public void TC16_CancelTicket() {
        Log.info("TC16_User can cancel a ticket");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        loginPage.loginAccount(configFileReader.getUsername(), configFileReader.getPassword());
        Log.info("Login with valid account");

        MyTicketPage myTicketPage = new MyTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        SuccessPage successPage = new SuccessPage();
        bookTicketPage.tabNavigate(Tab.BOOKTICKET);
        String departDateValue = Utilities.generateRandomNumberDepartDate();
        bookTicketPage.bookTicket(departDateValue, Station.SAIGON, Station.NHATRANG, SeatType.SBWAC, "1");
        String ticketID = successPage.getTicketID();
        Log.info("Book a ticket");

        myTicketPage.tabNavigate(Tab.MYITCKET);
        myTicketPage.deleteTicket(ticketID);
        Log.info("Click on \"My ticket\" tab");
        Log.info("Click on \"Cancel\" button of ticket which user want to cancel.");
        DriverManager.alertDriver().accept();
        Log.info(" Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        Assert.assertFalse(myTicketPage.isTicketDisplayed(ticketID));
    }
}
