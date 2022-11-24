package com.example.minhduong_exercise.testcases.changePassword;

import com.example.minhduong_exercise.dataObjects.Message;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.ChangePasswordPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_ChangePassword_ChangeSuccess extends BaseTestSetUp {

    @Test(description = "TC09_User can change password")
    public void TC09_ChangePasswordSuccess() {
        Log.info("TC09_User can change password");
        Log.info("Pre-condition: Create and activate a new account");

        Log.info("Create new account");
        registerRandomAccount();

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info("Login with new account");
        loginPage.loginAccount(getEmail(), getPassword());

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        Log.info("Click on 'Change Password' tab");
        changePasswordPage.tabNavigate(Tab.CHANGE_PASSWORD);
        String newPass = Utilities.generateRandomString(8);
        Log.info("Enter valid value into all fields.");
        Log.info("Click on 'Change Password' button");
        changePasswordPage.ChangePassword(getPassword(), newPass, newPass);
        Assert.assertEquals(changePasswordPage.getSuccessMessage(),Message.CHANGE_PASS_SUCCESS.getMessage());
    }

}
