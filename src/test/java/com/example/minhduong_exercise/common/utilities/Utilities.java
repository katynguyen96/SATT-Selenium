package com.example.minhduong_exercise.common.utilities;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

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
        String randomString = RandomStringUtils.randomAlphanumeric(len);
        return randomString;
    }

    public static String generateRandomStringWithSpecialCharacter(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk" + "lmnopqrstuvwxyz!@$%#&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }


    public static String generateRandomNumberDepartDate() {
        int randomeDate = (int) (Math.random() * 29 + 4);
        String s = Integer.toString(randomeDate);
        return s;
    }
}
