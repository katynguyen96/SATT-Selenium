package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataProvider.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_Login_EmptyUsername extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();
    @Test
    public void TC02_loginWithEmptyUserName() {
        Log.info("****** Test login with empty username ******");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate("Login");
        Log.info("Step #2: Click Login tab on NavBar");
        loginPage.loginAccount("", configFileReader.getPassword());
        Assert.assertEquals(loginPage.getFormErrorMessage(), "There was a problem with your login and/or errors exist in your form.");
    }
}
