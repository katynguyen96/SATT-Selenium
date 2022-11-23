package com.example.minhduong_exercise.testcases.register;

import com.example.minhduong_exercise.dataObjects.Message;
import com.example.minhduong_exercise.dataObjects.Tab;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_Register_InvalidConfirmPassword extends BaseTestSetUp {
    @Test(description = "TC10_User can't create account with 'Confirm password' is not the same with 'Password'")
    public void TC10_register_With_Invalid_Confirm_Password() {
        System.out.println("TC10_User can't create account with 'Confirm password' is not the same with 'Password'");
        Log.info("Navigate to QA Railway Website");
        RegisterPage registerPage = new RegisterPage();
        Log.info("Click on 'Register' tab");
        registerPage.tabNavigate(Tab.REGISTER);

        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        String confirmPassword = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);
        Log.info("Enter valid information into all fields except 'Confirm password' is not the same with 'Password'");
        Log.info("Click on 'Register' button");
        registerPage.registerAccount(email, password, confirmPassword, PID);
        Assert.assertEquals(registerPage.getFormErrorMessage(), Message.WRONG_INPUT.getMessage());
    }
}
