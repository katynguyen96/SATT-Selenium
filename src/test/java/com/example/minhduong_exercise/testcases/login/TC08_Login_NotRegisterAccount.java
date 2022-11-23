package com.example.minhduong_exercise.testcases.login;

import com.example.minhduong_exercise.dataObjects.Message;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.LoginPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08_Login_NotRegisterAccount extends BaseTestSetUp {
    @Test(description = "TC08_User can't login with an account hasn't been registered")
    public void TC08_login_With_Not_Activated_Account() {
        System.out.println("TC08_User can't login with an account hasn't been registered");
        Log.info("Navigate to QA Railway Website");
        Log.info("Click on \"Register\" tab");

        LoginPage loginPage = new LoginPage();
        Log.info(" Click on \"Login\" tab");
        loginPage.tabNavigate(Tab.LOGIN);
        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        Log.info(" Enter account hasn't been registered.");
        Log.info("Click on \"Login\" button");
        loginPage.loginAccount(email, password);
        Assert.assertEquals(loginPage.getErrorMessageInvalidAccount(), Message.WRONG_ACCOUNT.getMessage());
    }
}
