package com.todo.springboot.todospringbootcouchbase.controllers;

import com.couchbase.client.java.json.JsonObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.todo.springboot.todospringbootcouchbase.collections.User;
import com.todo.springboot.todospringbootcouchbase.error.ErrorResponse;
import com.todo.springboot.todospringbootcouchbase.services.UserService;
import com.todo.springboot.todospringbootcouchbase.utils.StringGenerator;
import com.todo.springboot.todospringbootcouchbase.utils.UserUtils;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<?> getUser(@RequestBody User user) {

        if (user == null) {
            return userService.getBadRequestError("bad request, user info missing from request");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()
                || user.getPassword() == null || user.getPassword().isEmpty()) {
            return userService.getBadRequestError("emailId or password is missing");
        }

        User dbUser = userService.getUser(user.getEmail());

        if (dbUser == null) {
            return userService.getBadRequestError("bad request, user not found");
        }

        if (!dbUser.getPassword().equals(user.getPassword())) {
            return userService.getBadRequestError("password is not matching");
        }

        dbUser.setPassword(null);
        return ResponseEntity.ok(dbUser);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        if (user == null)
            return userService.getBadRequestError("bad request, user info missing from request");

        if (user.getEmail() == null || user.getEmail().isEmpty()
                || user.getPassword() == null || user.getPassword().isEmpty())
            return userService.getBadRequestError("emailId or password is missing");

        User dbUser = userService.getUser(user.getEmail());
        if (dbUser != null) {
            return userService.getBadRequestError("user found");
        }

        user.setCreatedTime(System.currentTimeMillis());
        user.setUpdatedTime(System.currentTimeMillis());
        User createdUser = userService.save(user);
        createdUser.setPassword(null);

        return ResponseEntity.ok(createdUser);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dump-users")
    public ResponseEntity<?> dumpUsers(@RequestParam("count") long count) {

        if (count <= 0) return userService.getBadRequestError("invalid count");

        List<User> userList = UserUtils.getUsers(count);
        Iterable<User> createdList = userService.saveAll(userList);

        JsonObject jsonObject = JsonObject.create();
        jsonObject.put("successCount", true);

        return ResponseEntity.ok(jsonObject.toString());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users-count")
    public ResponseEntity<?> getUserCount() {

        long size = userService.getUserCount();

        JsonObject jsonObject = JsonObject.create();
        jsonObject.put("user_count", size);

        return ResponseEntity.ok(jsonObject.toString());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete-users")
    public ResponseEntity<?> deleteUsers() {
        userService.deleteUsers();

        JsonObject jsonObject = JsonObject.create();
        jsonObject.put("deleted", true);

        return ResponseEntity.ok(jsonObject.toString());
    }
}
