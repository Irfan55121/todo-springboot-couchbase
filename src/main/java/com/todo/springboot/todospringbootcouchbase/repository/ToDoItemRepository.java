package com.todo.springboot.todospringbootcouchbase.repository;


import com.todo.springboot.todospringbootcouchbase.collections.Todo;
import com.todo.springboot.todospringbootcouchbase.collections.TodoItem;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Scope("todo_user")
@Collection("todo_items")
public interface ToDoItemRepository extends CrudRepository<TodoItem,String> {

}