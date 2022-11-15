package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataProvider.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_Login_WrongPassSeveralTime extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test
    public void TC05_InputWrongPasswordSeveralTime() {
        Log.info("****** TC05 - System shows message when user enters wrong password several times ******");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN).click();
        Log.info("Click on \"Login\" tab");
        for (int i = 0; i < 4; i++) {
            loginPage.loginAccount(configFileReader.getUsername(), "123123123");
        }
        Log.info("Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        Log.info("Click on \"Login\" button");
        Log.info("Repeat step 3 three more times.");
        Assert.assertEquals(loginPage.getErrorMessageInvalidAccount(), "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
    }
}