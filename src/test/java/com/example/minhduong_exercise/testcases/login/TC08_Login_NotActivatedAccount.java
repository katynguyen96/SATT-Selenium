package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.constant.Url;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08_Login_NotActivatedAccount extends BaseTestSetUp {
    @Test
    public void TC08_login_With_Not_Activated_Account() {
        System.out.println("TC08 - User can't login with an account hasn't been activated");
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER.getTabName());
        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.registerAccount(email, password, password, PID);

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN.getTabName());
        loginPage.loginAccount(email, password);

        String loginPageUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(loginPageUrl, Url.LOGIN.getUrl());
        Assert.assertEquals(loginPage.getErrorMessageInvalidAccount(), "Invalid username or password. Please try again.");
    }

}
