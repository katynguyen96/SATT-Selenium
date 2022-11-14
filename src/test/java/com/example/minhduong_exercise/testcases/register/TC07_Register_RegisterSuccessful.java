package com.example.minhduong_exercise.testcases.register;

import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import com.example.minhduong_exercise.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_Register_RegisterSuccessful extends BaseTestSetUp {

    @Test
    public void TC07_register_Successfully_With_Valid_Account() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER.getTabName());

        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);

        registerPage.registerAccount(email, password, password, PID);
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "You're here");
    }
}
