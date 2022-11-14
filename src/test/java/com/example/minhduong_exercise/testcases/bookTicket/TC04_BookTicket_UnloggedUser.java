package com.example.minhduong_exercise.testcases.bookTicket;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.pageObjects.railway.BookTicketPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_BookTicket_UnloggedUser extends BaseTestSetUp {

    @Test
    public void TC04_UnLoggedUser() {
        System.out.println("TC04 - Display Login form when user click Book ticket tab without login");
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.tabNavigate(Tab.BOOKTICKET.getTabName());
        String loginUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(loginUrl, "http://www.railwayb2.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml");
    }
}
