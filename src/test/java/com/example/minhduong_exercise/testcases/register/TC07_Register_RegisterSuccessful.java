package com.example.minhduong_exercise.testcases.register;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.dataObjects.Message;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_Register_RegisterSuccessful extends BaseTestSetUp {

    @Test(description = "TC07_User can create new account")
    public void TC07_register_Successfully_With_Valid_Account() {
        Log.info("TC07_User can create new account");
        Log.info(" Navigate to QA Railway Website");
        RegisterPage registerPage = new RegisterPage();
        Log.info("Click on \"Register\" tab");
        registerPage.tabNavigate(Tab.REGISTER);
        Log.info("Enter valid information into all fields");
        Log.info("Click on \"Register\" button");
        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.registerAccount(email, password, password, PID);
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), Message.REGISTER.getMessage());
    }
}
