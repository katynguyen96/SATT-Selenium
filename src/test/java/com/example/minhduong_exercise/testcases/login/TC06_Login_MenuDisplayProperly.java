package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataProvider.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC06_Login_MenuDisplayProperly extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test
    public void TC06_ChangeTabMenu() {
        Log.info("TC06_Test UI tab menu after login");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN);
        Log.info("Click on \"Login\" tab");
        loginPage.loginAccount(configFileReader.getUsername(), configFileReader.getPassword());
        Log.info("Login with valid account");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isTabDisplayed("My ticket"));
        softAssert.assertTrue(loginPage.isTabDisplayed("Change password"));
        softAssert.assertTrue(loginPage.isTabDisplayed("Log out"));
        softAssert.assertAll();
    }
}
