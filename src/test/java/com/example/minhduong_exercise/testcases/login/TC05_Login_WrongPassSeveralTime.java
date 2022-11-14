package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_Login_WrongPassSeveralTime extends BaseTestSetUp {
    @Test
    public void TC05_InputWrongPasswordSeveralTime() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN.getTabName());
        for (int i = 0; i < 4; i++) {
            loginPage.loginAccount("abc@gmail.com", "123123123");
        }
        Assert.assertEquals(loginPage.getErrorMessageInvalidAccount(), "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
    }
}
