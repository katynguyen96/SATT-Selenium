package com.example.minhduong_exercise.testcases;

import com.example.minhduong_exercise.common.utilities.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTestSetUp {

    @DataProvider(name = "Valid Email Length")
    public static Object[][] validEmailLength() {
        return new Object[][]{{6}, {7}, {31}, {32}};
    }

    @DataProvider(name = "Invalid Email Length")
    public static Object[][] invalidEmailLength() {
        return new Object[][]{{5}, {33}};
    }

    @DataProvider(name = "Valid Password Length")
    public static Object[][] ValidPasswordLength() {
        return new Object[][]{{8}, {9}, {63}, {64}};
    }

    @DataProvider(name = "Valid PID Length")
    public static Object[][] ValidPIDLength() {
        return new Object[][]{{8}, {9}, {19}, {20}};
    }

    @DataProvider(name = "InValid Password Length")
    public static Object[][] InvalidPasswordLength() {
        return new Object[][]{{7}, {65}};
    }

    @DataProvider(name = "InValid PID Length")
    public static Object[][] InvalidPIDLength() {
        return new Object[][]{{7}, {21}};
    }

    @BeforeMethod
    public void setUp() {
        DriverManager.open();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.close();
    }
}
