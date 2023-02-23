package com.todo.springboot.todospringbootcouchbase.utils;

import com.todo.springboot.todospringbootcouchbase.collections.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoUtil {

    public static Todo getTodo(String userId){

        Todo todo = new Todo();
        todo.setTodo_title(StringGenerator.generateRandomString());
        todo.setUser_id(userId);
        todo.setCreated_time(System.currentTimeMillis());
        todo.setUpdated_time(System.currentTimeMillis());
        return todo;
    }

    public static List<Todo> getTodoList(String userId, long count){
        List<Todo> todoList = new ArrayList<>();
        for (int index = 0; index< count; index++){
            todoList.add(getTodo(userId));
        }
        return todoList;
    }
}
