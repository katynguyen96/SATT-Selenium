package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.dataObjects.Message;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.common.utilities.reader.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_Login_WrongPassSeveralTime extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05_InputWrongPasswordSeveralTime() {
        Log.info("TC05 - System shows message when user enters wrong password several times");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        Log.info("Click on \"Login\" tab");
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info("Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        Log.info("Click on \"Login\" button");
        Log.info("Repeat step 3 three more times.");
        for (int i = 0; i < 4; i++) {
            loginPage.loginAccount(configFileReader.getUsername(), "123123123");
        }
        Assert.assertEquals(loginPage.getErrorMessageInvalidAccount(), Message.MULTI_LOGIN.getMessage());
    }
}
