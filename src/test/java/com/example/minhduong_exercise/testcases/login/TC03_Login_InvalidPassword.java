package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.constant.Message;
import com.example.minhduong_exercise.common.constant.Tab;
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
        Log.info("TC03_Test login with invalid password");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info("Click on \"Login\" tab");
        loginPage.loginAccount(configFileReader.getUsername(), Utilities.generateRandomString(8));
        Log.info("Enter valid Email and invalid Password");
        Log.info(" Click on \"Login\" button");
        Assert.assertEquals(loginPage.getFormErrorMessage(), Message.WRONGACCOUNT.getMessage());
    }
}
