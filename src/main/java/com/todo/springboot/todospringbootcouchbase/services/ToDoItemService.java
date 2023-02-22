package com.todo.springboot.todospringbootcouchbase.services;

import com.todo.springboot.todospringbootcouchbase.collections.Todo;
import com.todo.springboot.todospringbootcouchbase.collections.TodoItem;
import com.todo.springboot.todospringbootcouchbase.controllers.BaseService;
import com.todo.springboot.todospringbootcouchbase.repository.ToDoItemRepository;
import com.todo.springboot.todospringbootcouchbase.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoItemService extends BaseService {

    @Autowired
    private ToDoItemRepository todoItemRepo;


    public ResponseEntity<?> getTodoList() {
        List<TodoItem> todoItems = new ArrayList<>();
        Iterable<TodoItem> all = todoItemRepo.findAll();
        all.forEach(todoItems::add);
        return ResponseEntity.ok(todoItems);
    }

    public ResponseEntity<?> save(TodoItem todoItem) {
        return ResponseEntity.ok(todoItemRepo.save(todoItem));
    }
}
