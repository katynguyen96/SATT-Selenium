package com.example.minhduong_exercise.testcases.changePassword;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.pageObjects.railway.ChangePasswordPage;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_ChangePassword_ChangeSuccess extends BaseTestSetUp {

    @Test
    public void TC09_ChangePasswordSuccess() {
        System.out.println("TC09 - User can change password");
        RegisterPage registerPage = new RegisterPage();

        registerPage.tabNavigate(Tab.REGISTER.getTabName());
        String email = Utilities.generateRandomEmail(9);
        String password = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.registerAccount(email, password, password, PID);

        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN.getTabName());
        loginPage.loginAccount(email, password);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.tabNavigate(Tab.CHANGEPASS.getTabName());
        String newPass = Utilities.generateRandomString(8);
        changePasswordPage.ChangePassword(password, newPass, newPass);
        Assert.assertTrue(changePasswordPage.getSuccessMessage().contains("Your password has been updated"));
    }

}
