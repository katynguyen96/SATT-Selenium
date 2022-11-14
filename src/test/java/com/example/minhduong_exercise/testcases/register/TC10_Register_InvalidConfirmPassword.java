package com.example.minhduong_exercise.testcases.register;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_Register_InvalidConfirmPassword extends BaseTestSetUp {
    @Test
    public void TC10_register_With_Invalid_Confirm_Password() {
        System.out.println("TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER.getTabName());

        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        String confirmPassword = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);

        registerPage.registerAccount(email, password, confirmPassword, PID);
        Assert.assertEquals(registerPage.getFormErrorMessage(), "There're errors in the form. Please correct the errors and try again.");
    }
}
