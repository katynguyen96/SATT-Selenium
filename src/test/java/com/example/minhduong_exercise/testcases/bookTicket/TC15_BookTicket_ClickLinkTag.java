package com.example.minhduong_exercise.testcases.bookTicket;

import com.example.minhduong_exercise.common.constant.ArriveStationConstant;
import com.example.minhduong_exercise.common.constant.Station;
import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.pageObjects.railway.TimetablePage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15_BookTicket_ClickLinkTag extends BaseTestSetUp {

    @Test
    public void TC15_Click_Book_ticket_LinkTag() {
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER.getTabName());
        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.registerAccount(email, password, password, PID);

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN.getTabName());
        loginPage.loginAccount(email, password);

        TimetablePage timetablePage = new TimetablePage();
        timetablePage.tabNavigate(Tab.TIMETABLE.getTabName());
        WebElement linkTag = timetablePage.getRow(Station.HUE.getTabName(), Station.SAIGON.getTabName());
        DriverManager.scrollToView(linkTag);
        linkTag.click();

        BookTicketPage bookTicketPage = new BookTicketPage();
        String selectedDepartStation = bookTicketPage.getSelectedDepartSationValue().getText();
        String selectedArriveStation = bookTicketPage.getSelectedArriveStationValue().getText();

        Assert.assertEquals(Station.HUE.getTabName(), selectedDepartStation);
        Assert.assertEquals(ArriveStationConstant.SAIGON.getTabName(), selectedArriveStation);
    }
}
