package com.example.minhduong_exercise.testcases.bookTicket;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.constant.*;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.*;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC14_BookTicket_Book1Ticket extends BaseTestSetUp {

    @Test
    public void TC14_Book_1_Ticket() {
        System.out.println("TC14_User can book 1 ticket at a time");
        Log.info("Pre-condition: Create and activate a new account");
        Log.info(" Navigate to QA Railway Website");
        registerAccount();
        Log.info("Register new account");

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        loginPage.loginAccount(getEmail(), getPassword());
        Log.info("Login with new account");

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.tabNavigate(Tab.BOOKTICKET);
        Log.info("Click on \"Book ticket\" tab");

        String departDateValue = Utilities.generateRandomNumberDepartDate();
        String departDate = bookTicketPage.getDepartDateValue(departDateValue);
        bookTicketPage.bookTicket(departDateValue, Station.SAIGON, Station.NHATRANG, SeatType.SBWAC, "1");
        Log.info("Select a \"Depart date\" from the list");
        Log.info("Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");
        Log.info("Select \"Soft bed with air conditioner\" for \"Seat type\"");
        Log.info(" Select \"1\" for \"Ticket amount\"");
        Log.info("Click on \"Book ticket\" button");
        SuccessPage successPage = new SuccessPage();
        String departStationValue = successPage.getRowValue("Depart Station");
        String arriveStationValue = successPage.getRowValue("Arrive Station");
        String seatTypeValue = successPage.getRowValue("Seat Type");
        String dateValue = successPage.getRowValue("Depart Date");
        String amountValue = successPage.getRowValue("Amount");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(bookTicketPage.getSuccessTitleValue(), Message.BOOKTICKETSUCCESS.getMessage());
        softAssert.assertEquals(departStationValue,Station.SAIGON.getStation());
        softAssert.assertEquals(arriveStationValue,Station.NHATRANG.getStation());
        softAssert.assertEquals(seatTypeValue,SeatType.SBWAC.getSeatType());
        softAssert.assertEquals(amountValue,"1");
        softAssert.assertEquals(dateValue,departDate);
        softAssert.assertAll();
    }
}
