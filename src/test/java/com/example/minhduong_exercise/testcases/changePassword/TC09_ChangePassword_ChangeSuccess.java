package com.example.minhduong_exercise.testcases.changePassword;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.ChangePasswordPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_ChangePassword_ChangeSuccess extends BaseTestSetUp {

    @Test
    public void TC09_ChangePasswordSuccess() {
        System.out.println("TC09_User can change password");
        Log.info("Pre-condition: Create and activate a new account");
        RegisterPage registerPage = new RegisterPage();

        registerAccount();
        Log.info("Create new account");

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN).click();
        loginPage.loginAccount(getEmail(), getPassword());
        Log.info("Login with new account");

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.tabNavigate(Tab.CHANGEPASS).click();
        Log.info("Click on \"Change Password\" tab");
        String newPass = Utilities.generateRandomString(8);
        changePasswordPage.ChangePassword(getPassword(), newPass, newPass);
        Log.info("Enter valid value into all fields.");
        Log.info("Click on \"Change Password\" button");
        Assert.assertTrue(changePasswordPage.getSuccessMessage().contains("Your password has been updated"));
    }

}