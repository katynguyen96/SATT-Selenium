package com.example.minhduong_exercise.testcases.bookTicket;

import com.example.minhduong_exercise.dataObjects.Station;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.TimetablePage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC15_BookTicket_ClickLinkTag extends BaseTestSetUp {

    @Test(description = "TC15_User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15_Click_Book_ticket_LinkTag() {
        Log.info("TC15_User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        Log.info("Pre-condition: Create and activate a new account");
        Log.info("Navigate to QA Railway Website");
        Log.info("Register new account");
        registerRandomAccount();

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info("Login with new account");
        loginPage.loginAccount(getEmail(), getPassword());

        TimetablePage timetablePage = new TimetablePage();
        Log.info("Click on \"Timetable\" tab");
        timetablePage.tabNavigate(Tab.TIME_TABLE);
        Log.info(" Click on \"book ticket\" link of the route from \"Huế\" to \"Sài Gòn\"");
        timetablePage.clickLink(Station.HUE, Station.SAI_GON);

        BookTicketPage bookTicketPage = new BookTicketPage();
        String selectedDepartStation = bookTicketPage.getSelectedDepartStationValue();
        String selectedArriveStation = bookTicketPage.getSelectedArriveStationValue();

        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(Station.HUE.getStation(), selectedDepartStation);
        softassert.assertEquals(Station.SAI_GON.getStation(), selectedArriveStation);
        softassert.assertAll();
    }
}
