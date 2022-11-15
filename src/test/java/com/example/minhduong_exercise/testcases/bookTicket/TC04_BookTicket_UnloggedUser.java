package com.example.minhduong_exercise.testcases.bookTicket;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_BookTicket_UnloggedUser extends BaseTestSetUp {

    @Test
    public void TC04_UnLoggedUser() {
        System.out.println("TC04_Display Login form when user click Book ticket tab without login");
        Log.info("Navigate to QA Railway Website");
        Log.info("Click on \"Book ticket\" tab");
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.tabNavigate(Tab.BOOKTICKET).click();
        String loginUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(loginUrl, "http://www.railwayb2.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml");
    }
}
