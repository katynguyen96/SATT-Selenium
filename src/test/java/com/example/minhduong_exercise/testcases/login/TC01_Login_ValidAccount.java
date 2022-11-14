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
        Log.info("****** Test login with valid account ******");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN.getTabName());
        Log.info("Step #2: Click Login tab on NavBar");
        loginPage.loginAccount(configFileReader.getUsername(), configFileReader.getPassword());
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome abc@gmail.com");
    }

}
