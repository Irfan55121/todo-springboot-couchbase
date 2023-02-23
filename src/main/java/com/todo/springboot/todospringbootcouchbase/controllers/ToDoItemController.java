package com.todo.springboot.todospringbootcouchbase.controllers;

import com.todo.springboot.todospringbootcouchbase.collections.Todo;
import com.todo.springboot.todospringbootcouchbase.collections.TodoItem;
import com.todo.springboot.todospringbootcouchbase.services.ToDoItemService;
import com.todo.springboot.todospringbootcouchbase.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET, value = "/dump-todo-items")
    public ResponseEntity<?> dumpTodoItems(@RequestParam("count") int count) {
        return toDoItemService.dumpTodoItems(count);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/count-todo-items")
    public ResponseEntity<?> getTodoItemCount() {
        return toDoItemService.count();
    }

}
