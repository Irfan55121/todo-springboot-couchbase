package com.todo.springboot.todospringbootcouchbase.services;

import com.todo.springboot.todospringbootcouchbase.collections.User;
import com.todo.springboot.todospringbootcouchbase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String emailId) {
        return userRepository.findUserByEmail(emailId);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public long getUserCount(){
        return userRepository.count();
    }

    public void deleteUsers(){
        userRepository.deleteAll();
    }

    public Iterable<User> saveAll(List<User> users){
        return userRepository.saveAll(users);
    }

}
