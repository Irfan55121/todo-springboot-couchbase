package com.todo.springboot.todospringbootcouchbase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.springboot.todospringbootcouchbase.collections.*;
import com.todo.springboot.todospringbootcouchbase.services.TodoServices;;;


@RestController
public class TodoController {

    @Autowired
    private TodoServices todoServices;

    @RequestMapping(method = RequestMethod.GET, value = "/todo")
    public ResponseEntity<?> getTodoList() {
        return todoServices.getTodoList();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/todo")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        return todoServices.save(todo);
    }
}
