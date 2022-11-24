package com.example.minhduong_exercise.testcases.bookTicket;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataObjects.Message;
import com.example.minhduong_exercise.dataObjects.SeatType;
import com.example.minhduong_exercise.dataObjects.Station;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.pageObjects.railway.*;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC14_BookTicket_Book1Ticket extends BaseTestSetUp {

    @Test(description = "TC14_User can book 1 ticket at a time")
    public void TC14_Book_1_Ticket() {
        Log.info("TC14_User can book 1 ticket at a time");
        Log.info("Pre-condition: Create and activate a new account");
        Log.info("Navigate to QA Railway Website");
        Log.info("Register new account");
        registerRandomAccount();

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info("Login with new account");
        loginPage.loginAccount(getEmail(), getPassword());

        BookTicketPage bookTicketPage = new BookTicketPage();
        Log.info("Click on 'Book ticket' tab");
        bookTicketPage.tabNavigate(Tab.BOOK_TICKET);

        String departDateValue = Utilities.generateRandomNumberDepartDate();
        String departDate = bookTicketPage.getDepartDateValue(departDateValue);
        Station departStation = Station.SAI_GON;
        Station arriveStation = Station.NHA_TRANG;
        SeatType seatType = SeatType.SBC;
        Log.info("Select a random 'Depart date' from the list");
        Log.info("Select "+departStation.getStation()+" for 'Depart from' and "+arriveStation.getStation()+" for 'Arrive at'.");
        Log.info("Select "+seatType.getSeatType()+" for 'Seat type'");
        Log.info("Select '1' for 'Ticket amount'");
        Log.info("Click on 'Book ticket' button");
        bookTicketPage.bookTicket(departDateValue, departStation, arriveStation, seatType, "1");

        SuccessPage successPage = new SuccessPage();
        String departStationValue = successPage.getRowValue("Depart Station");
        String arriveStationValue = successPage.getRowValue("Arrive Station");
        String seatTypeValue = successPage.getRowValue("Seat Type");
        String dateValue = successPage.getRowValue("Depart Date");
        String amountValue = successPage.getRowValue("Amount");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(bookTicketPage.getSuccessTitleValue(), Message.BOOK_TICKET_SUCCESS.getMessage());
        softAssert.assertEquals(departStationValue, departStation.getStation());
        softAssert.assertEquals(arriveStationValue, arriveStation.getStation());
        softAssert.assertEquals(seatTypeValue, seatType.getSeatType());
        softAssert.assertEquals(amountValue, "1");
        softAssert.assertEquals(dateValue, departDate);
        softAssert.assertAll();
    }
}
