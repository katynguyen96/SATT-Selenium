package com.example.minhduong_exercise.testcases;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestSetUp {
    @BeforeMethod
    public void setUpBrowser() {
        DriverManager.open();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.close();
    }
}
