package com.example.minhduong_exercise.testcases;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataObjects.Station;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.MyTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FTTC01_Filter_DpStation extends BaseTestSetUp {

    @Test
    public void FTTC01_Filter_DpStation() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER);
        Log.info("Create new account");
        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.registerAccount(email, password, password, PID);

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        loginPage.loginAccount(email, password);
        Log.info("Login with new account");

        BookTicketPage bookTicketPage = new BookTicketPage();
        Log.info("Book more than 6 ticket with different Depart Station");
        for(int i=1;i<=6;i++){
            bookTicketPage.tabNavigate(Tab.BOOK_TICKET);
            bookTicketPage.bookTicket(i);
        }

        Station dpStation = Station.QUANG_NGAI;
        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.tabNavigate(Tab.MY_TICKET);
        Log.info("Select Depart Station");
        Log.info("Click Apply filter");
        int listTicketLength = myTicketPage.filterDpStation(dpStation);
        Assert.assertTrue(myTicketPage.isTicketDisplay(dpStation, listTicketLength), dpStation.getStation() + " is not display");
    }
}
