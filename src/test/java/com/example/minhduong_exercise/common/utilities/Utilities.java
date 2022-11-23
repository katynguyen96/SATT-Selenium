package com.example.minhduong_exercise.common.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utilities {
    public static String getProjectPath() {
        return "@../../";
    }

    public static String generateRandomEmail(int len) {
        String domain = "@a.b";
        String randomString = RandomStringUtils.randomAlphanumeric(len - domain.length());
        return randomString + domain;
    }

    public static String generateRandomString(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }


    public static String generateRandomNumberDepartDate() {
        int randomDate = 3 + (int) (Math.random() * (30 - 4) + 1);
        return Integer.toString(randomDate);
    }
}
