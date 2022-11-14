package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataProvider.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_Login_InvalidPassword extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();
    @Test
    public void TC03_loginWithInvalidPassword() {
        Log.info("****** Test login with invalid password ******");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate("Login");
        Log.info("Step #2: Click Login tab on NavBar");
        loginPage.loginAccount(configFileReader.getUsername(), Utilities.generateRandomString(8));
        Assert.assertEquals(loginPage.getFormErrorMessage(), "Invalid username or password. Please try again.");
    }
}
