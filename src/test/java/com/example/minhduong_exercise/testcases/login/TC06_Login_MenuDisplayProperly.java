package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataProvider.ConfigFileReader;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_Login_MenuDisplayProperly extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test
    public void TC06_ChangeTabMenu() {
        Log.info("TC06_Test UI tab menu after login");
        Log.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.tabNavigate(Tab.LOGIN).click();
        Log.info("Click on \"Login\" tab");
        loginPage.loginAccount(configFileReader.getUsername(), configFileReader.getPassword());
        Log.info("Login with valid account");
        Assert.assertTrue(loginPage.getTab("My ticket").isDisplayed()
                && loginPage.getTab("Change password").isDisplayed()
                && loginPage.getTab("Log out").isDisplayed());
    }
}
