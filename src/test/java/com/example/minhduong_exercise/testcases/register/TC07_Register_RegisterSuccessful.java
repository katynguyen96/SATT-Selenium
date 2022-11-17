package com.example.minhduong_exercise.testcases.register;

import com.example.minhduong_exercise.common.constant.Message;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_Register_RegisterSuccessful extends BaseTestSetUp {

    @Test
    public void TC07_register_Successfully_With_Valid_Account() {
        Log.info("TC07_User can create new account");
        Log.info(" Navigate to QA Railway Website");
        RegisterPage registerPage = new RegisterPage();
        registerAccount();
        Log.info("Click on \"Register\" tab");
        Log.info("Enter valid information into all fields");
        Log.info("Click on \"Register\" button");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), Message.REGISTER.getMessage());
    }
}
