package com.todo.springboot.todospringbootcouchbase.services;

import com.todo.springboot.todospringbootcouchbase.collections.Todo;
import com.todo.springboot.todospringbootcouchbase.collections.TodoItem;
import com.todo.springboot.todospringbootcouchbase.repository.ToDoItemRepository;
import com.todo.springboot.todospringbootcouchbase.utils.TodoItemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoItemService extends BaseService {

    @Autowired
    private ToDoItemRepository todoItemRepo;

    @Autowired
    private TodoServices todoServices;

    public ResponseEntity<?> getTodoList() {
        List<TodoItem> todoItems = new ArrayList<>();
        Iterable<TodoItem> all = todoItemRepo.findAll();
        all.forEach(todoItems::add);
        return ResponseEntity.ok(todoItems);
    }

    public ResponseEntity<?> save(TodoItem todoItem) {
        return ResponseEntity.ok(todoItemRepo.save(todoItem));
    }

    public ResponseEntity<?> saveAll(List<TodoItem> todoItemList) {
        return ResponseEntity.ok(todoItemRepo.saveAll(todoItemList));
    }

    public void deleteAll() {
        todoItemRepo.deleteAll();
    }

    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(todoItemRepo.count());
    }

    public ResponseEntity<?> dumpTodoItems(int count) {
        Iterable<Todo> response = todoServices.getAll(100000);
        System.out.println("received objects:");
        response.forEach(todo -> {
            List<TodoItem> todoItemList = TodoItemUtil.getTodoList(todo.getTodo_id(), count);
            todoItemRepo.saveAll(todoItemList);
        });

        return ResponseEntity.ok(200);
    }
}
