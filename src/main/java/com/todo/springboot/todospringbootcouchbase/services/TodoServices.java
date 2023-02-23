package com.todo.springboot.todospringbootcouchbase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todo.springboot.todospringbootcouchbase.collections.*;
import com.todo.springboot.todospringbootcouchbase.repository.TodoRepository;

import java.util.List;
import java.util.ArrayList;


@Service
public class TodoServices extends BaseService {

    @Autowired
    private TodoRepository todoRepository;

    public ResponseEntity<?> getTodoList() {
        List<Todo> todoList = new ArrayList<>();
        Iterable<Todo> all = todoRepository.findAll();
        all.forEach(todoList::add);
        return ResponseEntity.ok(todoList);
    }

    public ResponseEntity<?> save(Todo todo) {
        if (todo.getUser_id() == null || todo.getUser_id().isEmpty())
            return getBadRequestError("userId is missing");
        if (todo.getTodo_title() == null || todo.getTodo_title().isEmpty())
            return getBadRequestError("todo title is missing");
        todo.setCreated_time(System.currentTimeMillis());
        todo.setUpdated_time(System.currentTimeMillis());
        return ResponseEntity.ok(todoRepository.save(todo));
    }
}
