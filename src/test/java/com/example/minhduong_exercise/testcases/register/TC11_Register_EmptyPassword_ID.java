package com.example.minhduong_exercise.testcases.register;

import com.example.minhduong_exercise.dataObjects.Message;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC11_Register_EmptyPassword_ID extends BaseTestSetUp {

    @Test(description = "TC11_User can't create account while password and PID fields are empty")
    public void TC11_register_With_Empty_Password_ID() {
        Log.info("TC11_User can't create account while password and PID fields are empty");
        Log.info("Navigate to QA Railway Website");
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER);
        Log.info("Click on \"Register\" tab");

        String email = Utilities.generateRandomEmail(8);
        Log.info("Enter valid email address and leave other fields empty");
        Log.info(" Click on \"Register\" button");
        registerPage.registerAccount(email, "", "", "");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registerPage.getFormErrorMessage(), Message.WRONG_INPUT.getMessage());
        softAssert.assertEquals(registerPage.getErrorMessagePassword(), Message.INVALID_PASS_LENGTH.getMessage());
        softAssert.assertEquals(registerPage.getErrorMessagePIDPassword(), Message.INVALID_ID_LENGTH.getMessage());
        softAssert.assertAll();
    }

}
