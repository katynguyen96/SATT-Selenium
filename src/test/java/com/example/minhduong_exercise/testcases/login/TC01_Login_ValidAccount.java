package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataProvider.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC01_Login_ValidAccount extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test
    public void TC01_loginWithValidAccount() {
        Log.info("****** TC01_Test login with valid account ******");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN).click();
        Log.info("Click on \"Login\" tab");
        loginPage.loginAccount(configFileReader.getUsername(), configFileReader.getPassword());
        Log.info("Enter email: " + configFileReader.getUsername());
        Log.info("Enter password: " + configFileReader.getPassword());
        Log.info("Click on \"Login\" button");
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome abc@gmail.com");
    }

}