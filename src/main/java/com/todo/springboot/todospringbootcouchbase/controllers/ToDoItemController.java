package com.todo.springboot.todospringbootcouchbase.controllers;

import com.todo.springboot.todospringbootcouchbase.collections.Todo;
import com.todo.springboot.todospringbootcouchbase.collections.TodoItem;
import com.todo.springboot.todospringbootcouchbase.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoItemController {

    @Autowired
    private ToDoItemService toDoItemService;


    @RequestMapping(method = RequestMethod.GET, value = "/todo-items")
    public ResponseEntity<?> getTodoList() {
        return toDoItemService.getTodoList();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/todo-items")
    public ResponseEntity<?> createTodoItem(@RequestBody TodoItem todo) {
        todo.setCreatedTime(System.currentTimeMillis());
        todo.setUpdatedTime(System.currentTimeMillis());
        return toDoItemService.save(todo);
    }
}
