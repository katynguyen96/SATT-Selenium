package com.example.minhduong_exercise.testcases.bookTicket;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.constant.*;
import com.example.minhduong_exercise.pageObjects.railway.*;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14_BookTicket_Book1Ticket extends BaseTestSetUp {


    @Test
    public void TC14_UnLoggedUser() {
        System.out.println("TC14 - User can book 1 ticket at a time");
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER.getTabName());
        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.registerAccount(email, password, password, PID);

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN.getTabName());
        loginPage.loginAccount(email, password);

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.tabNavigate(Tab.BOOKTICKET.getTabName());

        String departDateValue = Utilities.generateRandomNumberDepartDate();
        String departDate = bookTicketPage.departDate(departDateValue);
        bookTicketPage.bookTicket(departDateValue, Station.SAIGON, Station.NHATRANG, SeatType.SBWAC, "1");
        SuccessPage successPage = new SuccessPage();
        String departStationValue = successPage.getRow("Depart Station");
        String arriveStationValue = successPage.getRow("Arrive Station");
        String seatTypeValue = successPage.getRow("Seat Type");
        String dateValue = successPage.getRow("Depart Date");
        String amountValue = successPage.getRow("Amount");
        Assert.assertEquals(bookTicketPage.getSuccessTitle(), "Ticket Booked Successfully!");
        Assert.assertTrue(departStationValue.contains(Station.SAIGON.getTabName())
                && arriveStationValue.contains(ArriveStationConstant.NHATRANG.getTabName())
                && seatTypeValue.contains(SeatType.SBWAC.getTabName())
                && amountValue.contains("1")
                && dateValue.contains(departDate));
    }
}
