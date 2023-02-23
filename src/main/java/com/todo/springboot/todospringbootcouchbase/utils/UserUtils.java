package com.todo.springboot.todospringbootcouchbase.utils;

import com.todo.springboot.todospringbootcouchbase.collections.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    public static User getUser() {
        User user = new User();
        user.setPassword(StringGenerator.generateRandomString());
        user.setUpdatedTime(System.currentTimeMillis());
        user.setCreatedTime(System.currentTimeMillis());
        user.setEmail(StringGenerator.generateRandomEmail());
        return user;
    }

    public static List<User> getUsers(long count) {
        List<User> list = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            list.add(getUser());
        }
        return list;
    }
}
