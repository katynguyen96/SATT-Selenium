package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.common.utilities.reader.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC06_Login_MenuDisplayProperly extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test(description = "TC06_Test UI tab menu after login")
    public void TC06_ChangeTabMenu() {
        Log.info("TC06_Test UI tab menu after login");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        Log.info("Click on 'Login' tab");
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info("Login with valid account");
        loginPage.loginAccount(configFileReader.getUsername(), configFileReader.getPassword());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isTabDisplayed("My ticket"), "My ticket tab is not display on UI");
        softAssert.assertTrue(loginPage.isTabDisplayed("Change password"), "Change Password tab is not display on UI");
        softAssert.assertTrue(loginPage.isTabDisplayed("Log out"), "Log out tab is not display on UI");
        softAssert.assertAll();
    }
}
