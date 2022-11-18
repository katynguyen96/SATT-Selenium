package com.example.minhduong_exercise.testcases.bookTicket;

import com.example.minhduong_exercise.common.constant.Station;
import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.TimetablePage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC15_BookTicket_ClickLinkTag extends BaseTestSetUp {

    @Test
    public void TC15_Click_Book_ticket_LinkTag() {
        System.out.println("TC15_User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        Log.info("Pre-condition: Create and activate a new account");
        Log.info("Navigate to QA Railway Website");
        registerAccount();
        Log.info("Register new account");

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        loginPage.loginAccount(getEmail(), getPassword());
        Log.info("Login with new account");

        TimetablePage timetablePage = new TimetablePage();
        timetablePage.tabNavigate(Tab.TIMETABLE);
        Log.info("Click on \"Timetable\" tab");
        timetablePage.clickLink(Station.HUE, Station.SAIGON);
        Log.info(" Click on \"book ticket\" link of the route from \"Huế\" to \"Sài Gòn\"");

        BookTicketPage bookTicketPage = new BookTicketPage();
        String selectedDepartStation = bookTicketPage.getSelectedDepartStationValue();
        String selectedArriveStation = bookTicketPage.getSelectedArriveStationValue();

        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(Station.HUE.getStation(), selectedDepartStation);
        softassert.assertEquals(Station.SAIGON.getStation(), selectedArriveStation);
        softassert.assertAll();
    }
}
