package com.todo.springboot.todospringbootcouchbase.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;

import com.todo.springboot.todospringbootcouchbase.collections.Todo;

import org.springframework.data.repository.CrudRepository;


@Repository
@Scope("todo_user")
@Collection("todo")
public interface TodoRepository extends CrudRepository<Todo,String>{
    
}
