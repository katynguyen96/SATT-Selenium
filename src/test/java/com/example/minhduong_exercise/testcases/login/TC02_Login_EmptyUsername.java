package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.dataObjects.Message;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.common.utilities.reader.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_Login_EmptyUsername extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test(description = "TC02_Test login with empty username")
    public void TC02_loginWithEmptyUserName() {
        Log.info("TC02_Test login with empty username");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        Log.info("Click on \"Login\" tab");
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info("Enter password: " + configFileReader.getPassword());
        loginPage.loginAccount("", configFileReader.getPassword());
        Assert.assertEquals(loginPage.getFormErrorMessage(), Message.FORM_ERROR.getMessage());
    }
}
