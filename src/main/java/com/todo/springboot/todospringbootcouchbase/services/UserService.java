package com.todo.springboot.todospringbootcouchbase.services;

import com.todo.springboot.todospringbootcouchbase.collections.User;
import com.todo.springboot.todospringbootcouchbase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String emailId) {
        Iterable<User> userList = userRepository.findAll();
        for (User user : userList) {
            if (user.getEmail().equals(emailId)) return user;
        }
        return null;
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
