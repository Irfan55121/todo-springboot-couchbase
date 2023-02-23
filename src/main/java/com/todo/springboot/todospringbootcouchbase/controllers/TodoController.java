package com.todo.springboot.todospringbootcouchbase.controllers;

import java.util.List;

import com.couchbase.client.java.json.JsonObject;
import com.todo.springboot.todospringbootcouchbase.services.UserService;
import com.todo.springboot.todospringbootcouchbase.utils.TodoUtil;
import com.todo.springboot.todospringbootcouchbase.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todo.springboot.todospringbootcouchbase.collections.*;
import com.todo.springboot.todospringbootcouchbase.services.TodoServices;;;


@RestController
public class TodoController {

    @Autowired
    private TodoServices todoServices;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/todo")
    public ResponseEntity<?> getTodoList() {
        return todoServices.getTodoList();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/todo")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        return todoServices.save(todo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dump-todos")
    public ResponseEntity<?> dumpTodos(@RequestParam long count) {

        if (count <= 0) return todoServices.getBadRequestError("invalid count");
        Iterable<User> iterable = userService.getAllUsers();
        iterable.forEach(user -> {
            List<Todo> todoList = TodoUtil.getTodoList(user.getId(),count);
            ResponseEntity<?> createdList = todoServices.saveAll(todoList);
            createdList.getStatusCode();
        });

        JsonObject jsonObject = JsonObject.create();
        jsonObject.put("successCount", true);

        return ResponseEntity.ok(jsonObject.toString());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete-todos")
    public void deleteTodos(){
        todoServices.deleteAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/todo-count")
    public ResponseEntity<?> getTodosCount(){
       return ResponseEntity.ok(todoServices.getCount());
    }
}
