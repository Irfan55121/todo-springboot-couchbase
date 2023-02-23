package com.todo.springboot.todospringbootcouchbase.utils;

import java.util.UUID;

public class StringGenerator {

    public static String generateRandomString() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8).replaceAll("-", "");
    }

    public static String generateRandomEmail() {
        return generateRandomString() + "@" + generateRandomString().substring(0, 5) + ".com";
    }
}
