package com.example.minhduong_exercise.testcases.register;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.logs.Log;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11_Register_EmptyPassword_ID extends BaseTestSetUp {

    @Test
    public void TC11_register_With_Empty_Password_ID() {
        System.out.println("TC11_User can't create account while password and PID fields are empty");
        Log.info("Navigate to QA Railway Website");
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER).click();
        Log.info("Click on \"Register\" tab");

        String email = Utilities.generateRandomEmail(8);
        String confirmPassword = Utilities.generateRandomString(8);

        registerPage.registerAccount(email, "", confirmPassword, "");
        Log.info("Enter valid email address and leave other fields empty");
        Log.info(" Click on \"Register\" button");
        Assert.assertTrue(registerPage.getFormErrorMessage().contains("There're errors in the form. Please correct the errors and try again.")
                && registerPage.getErrorMessagePassword().contains("Invalid password length.")
                && registerPage.getErrorMessageConfirmPassword().contains("Invalid ID length."));
    }

}
