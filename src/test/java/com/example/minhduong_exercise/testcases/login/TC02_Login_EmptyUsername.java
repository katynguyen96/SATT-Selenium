package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.constant.Tab;
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
        Log.info("****** TC02_Test login with empty username ******");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN).click();
        Log.info("Click on \"Login\" tab");
        loginPage.loginAccount("", configFileReader.getPassword());
        Log.info("Enter password: " + configFileReader.getPassword());
        Assert.assertEquals(loginPage.getFormErrorMessage(), "There was a problem with your login and/or errors exist in your form.");
    }
}
