package com.example.minhduong_exercise.testcases.myTicket;

import com.example.minhduong_exercise.common.constant.SeatType;
import com.example.minhduong_exercise.common.constant.Station;
import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataProvider.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.MyTicketPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16_MyTicket_CancelTicket extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test
    public void TC16_CancelTicket() {
        Log.info("TC16_User can cancel a ticket");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        loginPage.loginAccount(configFileReader.getUsername(), configFileReader.getPassword());
        Log.info("Login with valid account");

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.tabNavigate(Tab.BOOKTICKET);
        String departDateValue = Utilities.generateRandomNumberDepartDate();
        bookTicketPage.bookTicket(departDateValue, Station.SAIGON, Station.NHATRANG, SeatType.SBWAC, "1");
        Log.info("Book a ticket");

        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.tabNavigate(Tab.MYITCKET);
        Log.info("Click on \"My ticket\" tab");
        myTicketPage.deleteTicket();
        Log.info("Click on \"Cancel\" button of ticket which user want to cancel.");
        DriverManager.alertDriver().accept();
        Log.info(" Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        if (myTicketPage.getNextTicketID() == null) {
            Assert.assertTrue(myTicketPage.isTableDisplayed());
        } else {
            Assert.assertNotEquals(myTicketPage.getDeletedTicketID(), myTicketPage.getNextTicketID());
        }
    }
}
