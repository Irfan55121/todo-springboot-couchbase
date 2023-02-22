package com.todo.springboot.todospringbootcouchbase.controllers;

import com.todo.springboot.todospringbootcouchbase.collections.User;
import com.todo.springboot.todospringbootcouchbase.error.ErrorResponse;
import com.todo.springboot.todospringbootcouchbase.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
