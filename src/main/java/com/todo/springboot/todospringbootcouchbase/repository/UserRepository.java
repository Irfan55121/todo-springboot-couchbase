package com.todo.springboot.todospringbootcouchbase.repository;


import com.todo.springboot.todospringbootcouchbase.collections.Todo;
import com.todo.springboot.todospringbootcouchbase.collections.User;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Scope("todo_user")
@Collection("user")
public interface UserRepository extends CrudRepository<User,String> {

    @Query("#{#n1ql.selectEntity} where email = $1")
    User findUserByEmail(String email);
}
