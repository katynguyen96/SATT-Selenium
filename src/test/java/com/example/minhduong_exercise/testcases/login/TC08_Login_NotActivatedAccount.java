package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.constant.Message;
import com.example.minhduong_exercise.common.constant.Url;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08_Login_NotActivatedAccount extends BaseTestSetUp {
    @Test
    public void TC08_login_With_Not_Activated_Account() {
        System.out.println("TC08_User can't login with an account hasn't been activated");
        Log.info("Pre-condition: Create a new account but do not activate it");
        Log.info("Navigate to QA Railway Website");
        Log.info("Click on \"Register\" tab");
        registerAccount();
        Log.info("Enter valid information into all fields");
        Log.info("Click on \"Register\" button");

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info(" Click on \"Login\" tab");
        loginPage.loginAccount(getEmail(), getPassword());
        Log.info(" Enter username and password of account hasn't been activated.");
        Log.info("Click on \"Login\" button");

        String loginPageUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(loginPageUrl, Url.LOGIN.getUrl());
        Assert.assertEquals(loginPage.getErrorMessageInvalidAccount(), Message.WRONGACCOUNT.getMessage());
    }

}
