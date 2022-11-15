package com.example.minhduong_exercise.testcases;

import com.example.minhduong_exercise.common.constant.Tab;
import com.example.minhduong_exercise.common.utilities.DriverManager;
import com.example.minhduong_exercise.common.utilities.Utilities;
import com.example.minhduong_exercise.pageObjects.railway.RegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestSetUp {

    private  String email;
    private String password;
    @BeforeMethod
    public void setUp() {
        DriverManager.open();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.close();
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
    public void registerAccount(){
        RegisterPage registerPage = new RegisterPage();
        registerPage.tabNavigate(Tab.REGISTER).click();
        email = Utilities.generateRandomEmail(8);
        password = Utilities.generateRandomString(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.registerAccount(email, password, password, PID);
    }
}
