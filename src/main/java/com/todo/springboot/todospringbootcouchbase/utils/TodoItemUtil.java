package com.todo.springboot.todospringbootcouchbase.utils;

import com.todo.springboot.todospringbootcouchbase.collections.Todo;
import com.todo.springboot.todospringbootcouchbase.collections.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class TodoItemUtil {


    public static TodoItem getTodoItem(String todoId){

        TodoItem todoItem = new TodoItem();
        todoItem.setTodoItemTitle(StringGenerator.generateRandomString());
        todoItem.setTodoId(todoId);
        todoItem.setCreatedTime(System.currentTimeMillis());
        todoItem.setUpdatedTime(System.currentTimeMillis());
        return todoItem;
    }

    public static List<TodoItem> getTodoList(String todoId, long count){
        List<TodoItem> todoList = new ArrayList<>();
        for (int index = 0; index< count; index++){
            todoList.add(getTodoItem(todoId));
        }
        return todoList;
    }
}
