package com.example.minhduong_exercise.testcases;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataObjects.Station;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.MyTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FTTC02_Filter_DepartDate extends BaseTestSetUp {
    @Test
    public void FTTC02_Filter_DepartDate() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER);
        Log.info("create new account");
        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.registerAccount(email, password, password, PID);

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        loginPage.loginAccount(email, password);
        Log.info("login with new account");

        Log.info("Book ticket more than 6 time");
        BookTicketPage bookTicketPage = new BookTicketPage();
        for (int i = 1; i <= 6; i++) {
            bookTicketPage.tabNavigate(Tab.BOOK_TICKET);
            bookTicketPage.bookTicket(i);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        Date date = new Date();
        String currentDay = dateFormat.format(date);
        MyTicketPage myTicketPage = new MyTicketPage();
        String dpDate = Utilities.generateRandomString(6);
        myTicketPage.tabNavigate(Tab.MY_TICKET);
        Log.info("input wrong depart date format");
        Log.info("Click Apply button");
        myTicketPage.filterDpDate(dpDate);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myTicketPage.getErrorMessage().contains("The date format is wrong, date filter is ignored."));
        softAssert.assertTrue(myTicketPage.getErrorMessage().contains("Example of a proper date: Today is " + currentDay), "current day is " + currentDay);
        softAssert.assertAll();
    }
}
